import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Counting_Rectangles {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int q = fs.nextInt();
            long pre[][] = new long[1001][1001];
            for (int i = 0; i < n; i++) {
                int h = fs.nextInt();
                int w = fs.nextInt();
                pre[h][w] += h * w;
            }

            // prefix sum preopogate
            for (int i = 1; i <= 1000; i++) {
                for (int j = 1; j <= 1000; j++) {
                    pre[i][j] += pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
                }
            }

            for (int i = 0; i < q; i++) {
                int hs = fs.nextInt();
                int ws = fs.nextInt();
                int hb = fs.nextInt();
                int wb = fs.nextInt();

                long ans = pre[hb - 1][wb - 1] - pre[hs][wb - 1] - pre[hb - 1][ws] + pre[hs][ws];
                System.out.println(ans);
            }
        }
    }

    /*
    
    
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