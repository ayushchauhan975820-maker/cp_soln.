import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Jellyfish_and_Mex {
    static final int mod = (int) 1e9 + 7;
    public static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n];
            map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
                if (a[i] >= n)
                    continue;
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }
            int mex = 0;
            while (map.containsKey(mex))
                mex++;
            for (int i = mex; i <= n; i++) {
                if (map.containsKey(i))
                    map.remove(i);
            }
            long dp[] = new long[mex + 1];
            Arrays.fill(dp, -1L);
            long ans = dfs(mex, dp);
            System.out.println(ans);
        }
    }

    public static long dfs(int cur_mex, long dp[]) {
        boolean has_moved = false;
        long ans = Long.MAX_VALUE;
        if (dp[cur_mex] != -1)
            return dp[cur_mex];
        for (int key : map.keySet()) {
            if (key >= cur_mex)
                continue;
            has_moved = true;
            ans = Math.min(ans, dfs(key, dp) + (map.get(key) - 1) * cur_mex + key);
        }
        if (!has_moved)
            return dp[cur_mex] = 0;
        return dp[cur_mex] = ans;
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