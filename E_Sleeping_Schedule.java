import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Sleeping_Schedule {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int h = fs.nextInt();
        int l = fs.nextInt();
        int r = fs.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }
        int dp[][] = new int[n + 1][h + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int good = dfs(a, h, l, r, 0, 0, dp);
        System.out.println(good);
    }

    public static int dfs(int a[], int h, int l, int r, int i, int t, int dp[][]) {
        if (i == a.length)
            return 0;

        if (dp[i][t] != -1)
            return dp[i][t];

        int t1 = (a[i] - 1 + t) % h;
        int t2 = (a[i] + t) % h;
        int mino = ((l <= t1 && t1 <= r) ? 1 : 0) + dfs(a, h, l, r, i + 1, t1, dp);
        int full = ((l <= t2 && t2 <= r) ? 1 : 0) + dfs(a, h, l, r, i + 1, t2, dp);

        return dp[i][t] = Math.max(mino, full);
    }

    /*
     * dp[i][j] -> max good times till ith time at jth hour
     * 
     * 
     * 
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