import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Beautiful_Sequence {
    static final int mod = 998244353;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }

            long co = 0;
            long ct = 0;
            long ans = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == 1) {
                    co++;
                }
                if (a[i] == 2) {
                    ct = ((2 * ct) + co) % mod;
                }
                if (a[i] == 3) {
                    ans = (ans + ct) % mod;
                }
            }

            System.out.println(ans);
        }
    }

    /*
     * all the sequences are of the form 1 2 2 2.. m 3
     * 1 2 3
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