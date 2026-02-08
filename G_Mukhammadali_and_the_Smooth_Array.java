import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class G_Mukhammadali_and_the_Smooth_Array {
    static final int mod = (int) 1e9 + 7;
    static int n;
    static int a[];
    static int c[];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            a = new int[n];
            c = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            long sum = 0;
            for (int i = 0; i < n; i++) {
                c[i] = fs.nextInt();
                sum += c[i];
            }
            long[] dp = new long[n];
            long best = 0;

            for (int i = 0; i < n; i++) {
                dp[i] = c[i];
                for (int j = 0; j < i; j++) {
                    if (a[j] <= a[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + c[i]);
                    }
                }
                best = Math.max(best, dp[i]);
            }

            System.out.println(sum - best);
        }
    }

    /*
     * dpij is the max cost till i - 1 with last pick at j
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
