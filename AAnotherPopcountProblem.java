import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class AAnotherPopcountProblem {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int bit[] = new int[32];
            bit[0] = n;
            for (int i = 0; i <= 25; i++) {
                if (bit[i] <= k)
                    break;

                int mv = 0;
                if ((bit[i] - k) % 2 == 0) {
                    mv = bit[i] - k;
                } else {
                    mv = bit[i] - k + 1;
                }

                bit[i] -= mv;
                bit[i + 1] += mv / 2;
            }

            long ct = 0;
            for (int i = 0; i <= 30; i++)
                ct += (long) bit[i];

            int mx = 0;
            for (int i = 0; i <= 25; i++) {
                if (bit[i] != 0)
                    mx = i;
            }
            if (mx != 0) {
                int dif = 0;
                for (int i = mx - 1; i >= 0; i--) {
                    if (bit[i] < k)
                        dif++;
                }
                ct = max(ct, ct - 1 + dif);
            }
            System.out.println(ct);

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