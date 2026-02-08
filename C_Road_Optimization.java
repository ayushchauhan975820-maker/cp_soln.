import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Road_Optimization {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        long inf = (long) 1e18;
        int n = fs.nextInt();
        int l = fs.nextInt();
        int k = fs.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = fs.nextInt();
        }

        long INF = (long) 1e18;

        long[][] dp = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {

                if (dp[i][j] == INF)
                    continue; // IMPORTANT

                for (int pos = i + 1; pos <= n; pos++) {
                    int removed = pos - i - 1;
                    if (j + removed > k)
                        continue;

                    long cost;
                    if (pos == n) {
                        cost = (long) (l - a[i]) * b[i];
                    } else {
                        cost = (long) (a[pos] - a[i]) * b[i];
                    }

                    dp[pos][j + removed] = Math.min(dp[pos][j + removed], dp[i][j] + cost);
                }
            }
        }

        long ans = INF;
        for (int j = 0; j <= k; j++) {
            ans = Math.min(ans, dp[n][j]);
        }

        System.out.println(ans);
    }

    /*
     * idx last k
     * dp[i][j] = min time to go from i to j if i is picked
     * j - i is the no of stops skipped b/w i and j
     * 
     * not pos if in a all bits exist in all the nums or all 0
     * 
     * i j can go to j + 1 (skp) or i + 1 (pick)
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