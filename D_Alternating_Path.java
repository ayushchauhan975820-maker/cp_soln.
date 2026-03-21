import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Alternating_Path {
    static final int mod = (int) 1e9 + 7;
    public static ArrayList<ArrayList<Integer>> graph;
    public static int vis[];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int u = fs.nextInt();
                int v = fs.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            vis = new int[n + 1];
            int tot = 0;
            for (int i = 1; i <= n; i++) {
                if (vis[i] == 0) {
                    int ans[] = dfs(i, 1);
                    if (ans[0] < 0)
                        continue;

                    tot += Math.max(ans[0], ans[1] - ans[0]);
                }
            }

            System.out.println(tot);
        }
    }

    public static int[] dfs(int node, int clr) {
        vis[node] = clr;

        int opp_clr = clr == 1 ? 2 : 1;

        int tot_s = (clr == 1) ? 1 : 0;
        int tot = 1;
        for (int i = 0; i < graph.get(node).size(); i++) {
            int neigh = graph.get(node).get(i);

            if (vis[neigh] == 0) {
                // vis the neigh
                int ans[] = dfs(neigh, opp_clr);
                if (ans[0] < 0 || ans[1] < 0 || tot < 0 || tot_s < 0) {
                    tot = Integer.MIN_VALUE / 4;
                    tot_s = Integer.MIN_VALUE / 4;
                } else {
                    tot_s += ans[0];
                    tot += ans[1];
                }
            } else {
                if (vis[neigh] == clr) {
                    // odd cycle
                    tot = Integer.MIN_VALUE / 4;
                    tot_s = Integer.MIN_VALUE / 4;
                }
            }
        }

        return new int[] { tot_s, tot };
    }

    /*
     * if a vertex v is alternative then all the subtrees of it can be alternative
     * 
     * any component that has an odd cycle in the original graph cant have
     * alternating edges
     * 
     * then from that component it is either alternating nodes or n - alternating
     * nodes
     * 
     * start from any vertex and count no of alternating nodes
     * its either nodes or no of nodes in that component - nodes
     * 
     * find component with odd cycles and discard them
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