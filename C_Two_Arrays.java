import java.io.*;
import java.util.*;

public class C_Two_Arrays {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int m = fs.nextInt();
        long dp[][][] = new long[m][n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(dfs(n, m, 0, 1, n, dp));
    }

    public static long dfs(int n, int m, int idx, int ai, int bi, long dp[][][]) {
        if (idx == m)
            return 1;

        if (ai > bi || ai > n || bi < 1)
            return 0;

        if (dp[idx][ai][bi] != -1)
            return dp[idx][ai][bi];

        dp[idx][ai][bi] = (dfs(n, m, idx + 1, ai, bi, dp) + dfs(n, m, idx, ai + 1, bi, dp) +
                dfs(n, m, idx, ai, bi - 1, dp) - dfs(n, m, idx, ai + 1, bi - 1, dp) + mod) % mod;

        return dp[idx][ai][bi];
    }

    /*
    
    */

    // fast scanner
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