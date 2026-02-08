import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class B_Array_Walk {

    static final int inf = (int) -1e9;
    public static int n;
    public static int k;
    public static int z;
    public static int[] a;
    public static int[][] dp;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            k = fs.nextInt();
            z = fs.nextInt();
            a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
            }

            dp = new int[n + 1][z + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], -1);
            }
            int ans = a[1] + rec(1, 0);
            System.out.println(ans);
        }
    }

    public static int rec(int idx, int taken) {
        int steps = (idx - 1) + taken * 2;
        if (steps == k)
            return 0;

        if (dp[idx][taken] != -1)
            return dp[idx][taken];

        int res = 0;
        if (steps + 1 <= k && idx < n) {
            res = Math.max(res, rec(idx + 1, taken) + a[idx + 1]);
        }
        if (steps + 1 == k && idx > 1 && taken < z) {
            res = Math.max(res, rec(idx, taken + 1) + a[idx - 1]);
        }
        if (steps + 2 <= k && idx > 1 && taken < z) {
            int sum = a[idx - 1] + a[idx];
            res = Math.max(res, rec(idx, taken + 1) + sum);
        }
        return dp[idx][taken] = res;
    }

    /*
     * dp[i][j] = dp[i][j - 1], dp[i - 1][j]
     * what will he do for k = 1
     * dp[i][j] = max score from 1 to i - 1 with j left spend
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