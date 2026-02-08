import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Rudolf_and_k_Bridges {
    static final int mod = (int) 1e9 + 7;
    public static int grid[][];
    public static int n;
    public static int m;
    public static int k;
    public static int d;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            m = fs.nextInt();
            k = fs.nextInt();
            d = fs.nextInt();
            grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = fs.nextInt();
                }
            }

            long dp[] = new long[n];
            for (int i = 0; i < n; i++) {
                dp[i] = cost(i);
            }

            // find min cost of k consecutive bridge
            long min = Long.MAX_VALUE;
            int l = 0;
            long cost = 0;
            for (int i = 0; i < n; i++) {
                cost += dp[i];
                while (i - l + 1 > k) {
                    cost -= dp[l];
                    l++;
                }
                if (i - l + 1 == k) {
                    min = Math.min(min, cost);
                }
            }

            System.out.println(min);
        }
    }

    public static long cost(int x) {
        TreeMap<Long, Integer> dp = new TreeMap<>();
        long ch[] = new long[m];
        ch[0] = 1;
        int l = 0;
        dp.put(1L, 1);
        for (int i = 1; i < m; i++) {
            int val = grid[x][i];
            // find the best cost for this idx
            while (i - l > d + 1) {
                long l_val = ch[l];
                if (dp.get(l_val) == 1) {
                    dp.remove(l_val);
                } else {
                    dp.put(l_val, dp.get(l_val) - 1);
                }
                l++;
            }
            long cost = 0;
            cost = dp.firstKey() + val + 1;
            dp.put(cost, dp.getOrDefault(cost, 0) + 1);
            ch[i] = cost;
        }

        return ch[m - 1];
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