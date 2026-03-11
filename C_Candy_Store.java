import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Candy_Store {
    static final int mod = (int) 1e9 + 7;
    public static long a[];
    public static long b[];

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            a = new long[n + 1];
            b = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
                b[i] = fs.nextInt();
            }

            int ct = 1;
            long cur_lcm = b[1];
            long cur_gcd = a[1] * b[1];

            for (int i = 2; i <= n; i++) {
                long next_gcd = gcd(cur_gcd, a[i] * b[i]);
                long next_lcm = (cur_lcm / gcd(cur_lcm, b[i])) * b[i];

                if (next_gcd % next_lcm == 0) {
                    cur_gcd = next_gcd;
                    cur_lcm = next_lcm;
                } else {
                    ct++;
                    cur_gcd = a[i] * b[i];
                    cur_lcm = b[i];
                }
            }

            System.out.println(ct);
        }
    }

    /*
     * let ci = ai * bi
     * 
     * d1 * b1 = d2 * b2 = d3 * b3
     * where di is some divisor of bi
     * 
     * d1 * b1 = d2 * b2
     * d1/d2 = b2/b1
     * for merging
     * that means
     * we know x1 = b1/gcd(b1, b2)
     * x2 = b2/gcd(b1, b2)
     * 
     * now x1 must divide a1
     * and x2 must divide a2
     * 
     * 
     * now if we add d3 * b3
     * then
     * d1 * b1 = d3 * b3
     * d1/d3 = b3/b1
     * for merging
     * that means
     * we know x1 = b1/gcd(b1, b3)
     * x3 = b3/gcd(b1, b3)
     * and also x3 in both case must be equal
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