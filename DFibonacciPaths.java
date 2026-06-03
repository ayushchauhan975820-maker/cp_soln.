import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class DFibonacciPaths {
    static final long mod = (long) 998244353;
    public static ArrayList<ArrayList<Integer>> gph;
    public static long a[];
    public static long ans;
    public static HashMap<Long, Long> dp;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            ans = 0;
            a = new long[n + 1];
            dp = new HashMap<>();
            gph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                gph.add(new ArrayList<>());
                if (i > 0) {
                    a[i] = fs.nextLong();
                }
            }
            for (int i = 0; i < m; i++) {
                int v = fs.nextInt();
                int u = fs.nextInt();
                gph.get(v).add(u);
            }

            for (int i = 1; i <= n; i++) {
                for (int child : gph.get(i)) {
                    long res = dfs(child, i);
                    ans = (ans + res + 1) % mod;
                }
            }

            System.out.println(ans);
        }
    }

    public static long dfs(int node, int prev) {
        long val = 0;
        long key = Key(node, prev);
        if (dp.containsKey(key))
            return dp.get(key);

        for (int child : gph.get(node)) {
            if (a[child] - a[node] != a[prev])
                continue;

            long res = dfs(child, node);

            val = (val + res + 1) % mod;
        }
        dp.put(key, val);
        return val;
    }

    public static long Key(int a, int b) {
        return (long) a << 32 | b;
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