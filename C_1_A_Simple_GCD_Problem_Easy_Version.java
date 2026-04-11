import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_1_A_Simple_GCD_Problem_Easy_Version {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n + 1];
            int b[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                b[i] = fs.nextInt();
            }

            int ct = 0;
            for (int i = 1; i <= n; i++) {
                if (i != 1 && i != n) {
                    int gl = gcd(a[i], a[i - 1]);
                    int gr = gcd(a[i], a[i + 1]);
                    int g = gcd(gl, gr);

                    if (((long) gl / g) * (long) gr < a[i])
                        ct++;
                }

                if (i == 1 && gcd(a[i], a[i + 1]) < a[i])
                    ct++;
                if (i == n && gcd(a[i], a[i - 1]) < a[i])
                    ct++;
            }

            System.out.println(ct);
        }
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /*
     * gcd(al -> ar) = gcd(a'l -> a'r)
     * 
     * for a idx i it must maintain the gcd with its left and right
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