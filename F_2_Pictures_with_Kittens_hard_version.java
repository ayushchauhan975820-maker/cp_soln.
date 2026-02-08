import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class F_2_Pictures_with_Kittens_hard_version {
    static final int mod = (int) 1e9 + 7;
    static final long NEG = (long) -1e18;
    static int n;
    static int k;
    static int x;
    static long[] a;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        n = fs.nextInt();
        k = fs.nextInt();
        x = fs.nextInt();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextLong();
        }
        long dp[][][] = new long[n + 1][k + 1][x + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        if ((n) / k > x) {
            System.out.println(-1);
        } else {
            long ans = rec(0, 0, 0, dp);
            System.out.println(ans);
        }
    }

    public static long rec(int i, int d, int pck, long dp[][][]) {
        if (pck > x)
            return NEG;
        if (pck + (n - i) < x)
            return NEG;
        if (i == n) {
            if (pck == x)
                return 0;
            return NEG;
        }
        if (dp[i][d][pck] != -1)
            return dp[i][d][pck];
        long ans = NEG;
        ans = Math.max(ans, rec(i + 1, 0, pck + 1, dp) + a[i]);
        if (d + 1 < k) {
            ans = Math.max(ans, rec(i + 1, d + 1, pck, dp));
        }

        return dp[i][d][pck] = ans;
    }

    /*
     * dp[last][i][x] 200 * 200 * 200
     * 
     * k
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