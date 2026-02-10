import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_1_Set_To_Max_Easy_Version {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
                if (!map.containsKey(a[i])) {
                    map.put(a[i], new ArrayList<>());
                }
                map.get(a[i]).add(i);
            }
            boolean valid = true;
            for (int i = 0; i < n; i++) {
                b[i] = fs.nextInt();
                if (b[i] < a[i])
                    valid = false;
                if (!map.containsKey(b[i]))
                    valid = false;
            }

            if (!valid) {
                System.out.println("NO");
                continue;
            }

            for (int val : map.keySet()) {
                ArrayList<Integer> list = map.get(val);
                for (int idx : list) {
                    // go right
                    for (int i = idx + 1; i < n; i++) {
                        if (a[i] > a[idx] || a[i] == b[i]) {
                            break;
                        } else {
                            a[i] = a[idx];
                        }
                    }
                    // go left
                    for (int i = idx - 1; i >= 0; i--) {
                        if (a[i] > a[idx] || a[i] == b[i]) {
                            break;
                        } else {
                            a[i] = a[idx];
                        }
                    }
                }
            }

            // check
            for (int i = 0; i < n; i++) {
                if (a[i] != b[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    /*
     * at a place no can only inc it can never decrease
     * brute force and simulate from smallest to the largest
     */

    // FastScanner
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do
                c = read();
            while (c <= ' ');
            if (c == '-') {
                sign = -1;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c, sign = 1;
            long val = 0;
            do
                c = read();
            while (c <= ' ');
            if (c == '-') {
                sign = -1;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        String next() throws IOException {
            int c;
            StringBuilder sb = new StringBuilder();
            do
                c = read();
            while (c <= ' ');
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}