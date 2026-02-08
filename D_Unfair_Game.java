import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Unfair_Game {
    static final int mod = (int) 1e9 + 7;
    static long[][] C = new long[32][32];

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 32; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= i; j++)
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
        }

        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();

            int d = 0;
            while ((1 << d) < n)
                d++;

            long ans = 0;

            for (int i = 0; i < d; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i + 1 + j > k) {
                        ans += C[i][j];
                    }
                }
            }

            if (d + 1 > k)
                ans++;

            System.out.println(ans);
        }
    }

    /*
     * remove all bits by shifting and dividing = popc + msb
     * for a msb idx i add i + j + 1 > k
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