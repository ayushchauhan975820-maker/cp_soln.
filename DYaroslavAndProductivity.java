import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class DYaroslavAndProductivity {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            long a[] = new long[n];
            long dp[][] = new long[n + 1][2];
            long pref[] = new long[n];
            for (int i = 0; i <= n; i++) {
                dp[i][0] = Long.MIN_VALUE;
                dp[i][1] = Long.MIN_VALUE;
            }
            HashSet<Integer> set = new HashSet<>();
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
                sum += a[i];
                pref[i] = sum;
            }
            for (int i = 0; i < m; i++) {
                int val = fs.nextInt();
                set.add(val - 1);
            }
            dp[n][0] = sum;
            for (int i = n - 1; i >= 0; i--) {
                dp[i][0] = dp[i + 1][0];
                dp[i][1] = dp[i + 1][1];
                if (set.contains(i)) {
                    if (dp[i + 1][1] != Long.MIN_VALUE)
                        dp[i][0] = max(dp[i][0], dp[i + 1][1] + 2 * pref[i]);
                    if (dp[i + 1][0] != Long.MIN_VALUE)
                        dp[i][1] = max(dp[i][1], dp[i + 1][0] - 2 * pref[i]);
                }
            }

            System.out.println(max(dp[0][0], dp[0][1]));
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