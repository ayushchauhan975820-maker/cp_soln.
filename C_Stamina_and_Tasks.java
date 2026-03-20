import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Stamina_and_Tasks {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int c[] = new int[n + 1];
            int p[] = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                c[i] = fs.nextInt();
                p[i] = fs.nextInt();
            }

            double ans[] = new double[n + 1];
            ans[n] = c[n];
            for (int i = n - 1; i >= 1; i--) {
                ans[i] = Math.max(ans[i + 1], (((100 - p[i]) / 100.0) * ans[i + 1]) + c[i]);
            }

            System.out.println(ans[1]);
        }
    }

    /*
     * Points = si * ci + si(100 - pi)/100 * cj + si(100 - pi)/100(100 - pi)/100 *
     * ck
     * si (ci + (100 - pi)/100 cj + (100 - pi)(100 - pj)/10000 ck + .....)
     * 
     * we have to go from 1 to n and can skip
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