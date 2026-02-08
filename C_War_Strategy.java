import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_War_Strategy {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int k = fs.nextInt();

            int l = k - 1;
            int r = n - k;
            if (l < r) {
                l = n - k;
                r = k - 1;
            }

            int a = 0;
            int b = 0;
            while (true) {
                if (b < r && a + (b + 1) + Math.max(a, b + 1) - 1 <= m) {
                    b++;
                }
                if (a < l && (a + 1) + b + Math.max(a + 1, b) - 1 <= m) {
                    a++;
                } else {
                    break;
                }
            }
            System.out.println(a + b + 1);
        }
    }
    /*
     * increase the army or expand it
     * a a f f a
     * moving as a whole is better
     * 
     * collection takes x + left - 1 d
     * 
     * x to acc y need to acc
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