import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class FIgorAndMountain {
    static final int mod = 998244353;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int d = fs.nextInt();
            char grid[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                grid[i] = fs.next().toCharArray();
            }

            int mx_mov = 0;
            for (int i = 0; i <= 2000; i++) {
                boolean pos = (i * i + 1) <= (d * d);
                if (pos) {
                    mx_mov = i;
                } else {
                    break;
                }
            }

            long dp[][][] = new long[n][m][2];
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < 2; k++) {
                    // sweep
                    for (int j = 1; j < m; j++) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i][j - 1][k]) % mod;
                        if (dp[i][j][k] < 0)
                            dp[i][j][k] += mod;
                    }

                    if (i == 0 && k == 0) {
                        for (int j = 0; j < m; j++) {
                            if (grid[i][j] == 'X')
                                dp[i][j][k]++;
                        }
                    }

                    if (k == 0) {
                        for (int j = 0; j < m; j++) {
                            if (grid[i][j] != 'X' || dp[i][j][0] == 0)
                                continue;
                            int l = max(0, j - d);
                            int r = min(m - 1, j + d);

                            dp[i][l][1] += dp[i][j][0];
                            dp[i][j][1] -= dp[i][j][0];
                            if (j < m - 1)
                                dp[i][j + 1][1] += dp[i][j][0];
                            if (r < m - 1)
                                dp[i][r + 1][1] -= dp[i][j][0];
                        }

                        if (i == n - 1)
                            continue;
                        for (int j = 0; j < m; j++) {
                            if (grid[i][j] != 'X' || dp[i][j][0] == 0)
                                continue;
                            int l = max(0, j - mx_mov);
                            int r = min(m - 1, j + mx_mov);

                            dp[i + 1][l][0] += dp[i][j][0];
                            if (r < m - 1)
                                dp[i + 1][r + 1][0] -= dp[i][j][0];
                        }
                    } else {
                        if (i == n - 1)
                            continue;
                        for (int j = 0; j < m; j++) {
                            if (grid[i][j] != 'X' || dp[i][j][1] == 0)
                                continue;
                            int l = max(0, j - mx_mov);
                            int r = min(m - 1, j + mx_mov);

                            dp[i + 1][l][0] += dp[i][j][1];
                            if (r < m - 1)
                                dp[i + 1][r + 1][0] -= dp[i][j][1];
                        }
                    }
                }
            }

            long sum = 0;
            for (int i = 0; i < m; i++) {
                if (grid[n - 1][i] != 'X')
                    continue;
                sum = (sum + dp[n - 1][i][1]) % mod;
                sum = (sum + dp[n - 1][i][0]) % mod;
            }

            System.out.println(sum);
        }
    }

    /*
     * dp[i][j][k] -> at hold i, j with (k + 1)th hand
     * 
     * dp[i][j][0] -> (dp[i - 1][j][1] + 1) (i - 1, j) who can reach
     * dp[i][j][1] -> (dp[i][j][0] + 1) all who can be reached
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