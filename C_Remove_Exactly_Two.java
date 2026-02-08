import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Remove_Exactly_Two {
    static final int mod = (int) 1e9 + 7;
    public static ArrayList<ArrayList<Integer>> tree;
    public static int max;
    public static boolean vis[];
    public static int dp[];
    public static int child_dp[];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            max = (int) (-1e8);
            tree = new ArrayList<>();
            vis = new boolean[n + 1];
            dp = new int[n + 1];
            child_dp = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }
            for (int i = 2; i <= n; i++) {
                int u = fs.nextInt();
                int v = fs.nextInt();
                tree.get(u).add(v);
                tree.get(v).add(u);
            }
            for (int i = 0; i <= n; i++) {
                dp[i] = tree.get(i).size();
            }

            // find adjacent pair
            dfs(1, 0);
            // find two non adjacent nodes
            Arrays.fill(vis, false);
            non_adj(1);
            System.out.println(max);
        }
    }

    public static void dfs(int node, int par) {
        vis[node] = true;
        int child_comp = tree.get(node).size();
        int par_comp = tree.get(par).size();

        if (par != 0) {
            max = Math.max(max, child_comp + par_comp - 2);
        }

        for (int child : tree.get(node)) {
            if (vis[child])
                continue;
            dfs(child, node);
        }

        return;
    }

    public static void non_adj(int node) {
        // try to connect this node with its subchilds
        vis[node] = true;
        int max_branch = 0;
        int sec_max_branch = 0;
        for (int subchilds : tree.get(node)) {
            if (!vis[subchilds]) {
                non_adj(subchilds);
                if (child_dp[subchilds] > 0) {
                    max = max(max, child_dp[subchilds] + tree.get(node).size() - 1);
                }

                if (dp[subchilds] > max_branch) {
                    sec_max_branch = max_branch;
                    max_branch = dp[subchilds];
                } else if (dp[subchilds] > sec_max_branch) {
                    sec_max_branch = dp[subchilds];
                }

                dp[node] = Math.max(dp[node], dp[subchilds]);
            }
        }

        child_dp[node] = max_branch;
        if (sec_max_branch > 0) {
            max = Math.max(max, sec_max_branch + max_branch - 1);
        }
    }
    /*
     * 
     * pick two nodes that dont share a edge then a + b - 1
     * that may be same subtree or different subtree
     * else two nodes that share a edge then a + b - 2
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