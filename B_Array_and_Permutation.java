import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class B_Array_and_Permutation {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n + 1];
            int p[] = new int[n + 1];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                p[i] = fs.nextInt();
                map.put(p[i], i);
            }
            int lst = 0;
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
            }
            boolean valid = true;
            for (int i = 1; i <= n; i++) {
                // found right
                int pos = map.get(a[i]);
                if (pos < lst) {
                    valid = false;
                    break;
                } else {
                    lst = pos;
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
     * p is a permutation so we can kind of sim
     * 
     * 
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