import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Idiot_First_Search {
    static final int mod = (int) 1e9 + 7;
    public static int[][] tree;
    public static long ans[];
    public static long dp[];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            tree = new int[n + 1][2];
            ans = new long[n + 1];
            dp = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                int l = fs.nextInt();
                int r = fs.nextInt();
                tree[i][0] = l;
                tree[i][1] = r;
            }

            dfs(1);

            ans[1] = dp[1];
            cans(1);

            for (int i = 1; i <= n; i++) {
                long val = ans[i];
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int u) {
        int l = tree[u][0];
        int r = tree[u][1];

        if (l == 0 && r == 0) {
            dp[u] = 1;
        } else {
            dfs(l);
            dfs(r);
            dp[u] = (dp[l] + dp[r] + 3) % mod;
        }
    }

    public static void cans(int u) {
        int l = tree[u][0];
        int r = tree[u][1];

        if (l != 0) {
            ans[l] = (ans[u] + dp[l]) % mod;
            cans(l);
        }
        if (r != 0) {
            ans[r] = (ans[u] + dp[r]) % mod;
            cans(r);
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