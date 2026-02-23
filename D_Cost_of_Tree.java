import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Cost_of_Tree {
    static final int mod = (int) 1e9 + 7;
    public static int n;
    public static ArrayList<Integer>[] tree;
    public static int wt[];
    public static int ht[];
    public static int bch[];
    public static long ans[];
    public static long sub[];
    public static long precalc[];
    public static int par[];
    public static long base_cost[];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            tree = new ArrayList[n + 1];
            wt = new int[n + 1];
            ht = new int[n + 1];
            bch = new int[n + 1];
            ans = new long[n + 1];
            sub = new long[n + 1];
            par = new int[n + 1];
            precalc = new long[n + 1];
            base_cost = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                wt[i] = fs.nextInt();
            }
            for (int i = 0; i <= n; i++) {
                tree[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                int u = fs.nextInt();
                int v = fs.nextInt();
                tree[u].add(v);
                tree[v].add(u);
            }

            dfs_wt_ht(1, 0);
            Arrays.fill(precalc, -1);
            calc(1, 0);
            find(1, 0);
            for (int i = 1; i <= n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs_wt_ht(int node, int parent) {
        par[node] = parent;
        long height = 0;
        long sub_wt = wt[node];
        int ct = 0;
        int branch = -1;
        long cur_base_cost = 0;
        for (int child : tree[node]) {
            if (child == parent)
                continue;
            ct++;
            dfs_wt_ht(child, node);
            height = max(height, ht[child] + 1);
            sub_wt += sub[child];
            cur_base_cost += base_cost[child] + sub[child];
            if (bch[child] != -1)
                branch = bch[child];
        }

        if (ct > 1) {
            bch[node] = node;
        } else {
            bch[node] = branch;
        }
        ht[node] = (int) height;
        sub[node] = sub_wt;
        base_cost[node] = cur_base_cost;
    }

    public static void calc(int node, int parent) {
        for (int child : tree[node]) {
            if (child == parent)
                continue;
            calc(child, node);
        }

        if (bch[node] != -1 && precalc[bch[node]] == -1) {
            ArrayList<long[]> list = new ArrayList<>();
            int bch_node = bch[node];
            for (int child : tree[bch_node]) {
                if (child == par[bch_node])
                    continue;
                list.add(new long[] { ht[child], sub[child], child });
            }
            // find the depest height and second deppest
            Collections.sort(list, (x, y) -> Long.compare(y[0], x[0]));
            // for first do with sec and for rest all do with first
            long max = list.get(0)[1] * (list.get(1)[0] + 1);
            for (int i = 1; i < list.size(); i++) {
                max = max(max, list.get(i)[1] * (list.get(0)[0] + 1));
            }
            for (long[] arr : list) {
                int child_id = (int) arr[2];
                long best_child_ans = (bch[child_id] == -1 ? 0 : precalc[bch[child_id]]);
                max = max(max, best_child_ans);
            }
            precalc[bch_node] = max;
        }
    }

    public static void find(int node, int parent) {
        long an = (bch[node] == -1 ? 0 : precalc[bch[node]]);
        ans[node] = base_cost[node] + an;

        for (int child : tree[node]) {
            if (child == parent)
                continue;
            find(child, node);
        }
    }

    /*
     * change in cost after the ops will be
     * (previous cost + (sum of node of subtree to move * change in height))
     * 
     * for every node calc height of all the subtree and sum of their cost
     * and precalc previous cost
     * 
     * else pick
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