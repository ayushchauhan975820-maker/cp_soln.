import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Portal {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int x = fs.nextInt();
            int y = fs.nextInt();
            int a[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
            }

            ArrayList<Integer> mid = new ArrayList<>();
            ArrayList<Integer> seq = new ArrayList<>();
            int pc = (x == 0) ? 1 : 0;
            for (int i = 1; i <= n; i++) {
                if (pc == 1) {
                    mid.add(a[i]);
                } else {
                    seq.add(a[i]);
                }
                if (i == x || i == y)
                    pc++;
            }

            // rotate mid
            int sm = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < mid.size(); i++) {
                if (mid.get(i) < sm) {
                    sm = mid.get(i);
                    idx = i;
                }
            }
            boolean valid = true;
            int st = n + 1;
            for (int i = 0; i < seq.size(); i++) {
                if (seq.get(i) > sm) {
                    valid = false;
                }
                if (valid) {
                    System.out.print(seq.get(i) + " ");
                } else {
                    st = i;
                    break;
                }
            }
            for (int i = idx; i < mid.size(); i++) {
                System.out.print(mid.get(i) + " ");
            }
            for (int i = 0; i < idx; i++) {
                System.out.print(mid.get(i) + " ");
            }
            for (int i = st; i < seq.size(); i++) {
                System.out.print(seq.get(i) + " ");
            }
            System.out.println();
        }
    }

    /*
     * cyclic permutation in the middle and all the elements smaller int he left of
     * the portal
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