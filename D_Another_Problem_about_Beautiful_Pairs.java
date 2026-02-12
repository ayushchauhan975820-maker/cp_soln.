import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Another_Problem_about_Beautiful_Pairs {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int rn = 0;
            while (rn * rn <= n)
                rn++;
            int ct = 0;
            int p[] = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                p[j] = fs.nextInt();
            }

            for (int val_i = 1; val_i <= rn; val_i++) {
                for (int j = 1; j <= n; j++) {
                    // a[j]*val_i = j - i => i = j - a[j]_val_i
                    long i = j - (long) p[j] * val_i;
                    if (i > 0 && i <= n && p[(int) i] == val_i)
                        ct++;
                }
            }

            for (int i = 1; i <= n; i++) {
                int val = p[i];
                if (val <= rn)
                    continue;
                // check for large values like 1, 2.. etc
                for (int j = i + val; j <= n; j += val) {
                    if ((j - i) == p[j] * (long) val)
                        ct++;
                }
            }

            System.out.println(ct);
        }
    }

    /*
     * ai * aj = j - i
     * k * aj = j - i
     * i = j - k * aj
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