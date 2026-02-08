import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Tree_Jumps {
    static final int mod = (int) 998244353;
    public static ArrayList<ArrayList<Integer>> tree;
    public static ArrayList<ArrayList<Integer>> lvl_tree;
    public static HashMap<Integer, Integer> parent;
    public static HashMap<Integer, Long> comp_sum;
    public static long prev_sum;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            // build tree
            tree = new ArrayList<>();
            lvl_tree = new ArrayList<>();
            parent = new HashMap<>();
            comp_sum = new HashMap<>();
            parent.put(1, 0);
            prev_sum = 0;
            for (int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }
            for (int i = 2; i <= n; i++) {
                int par = fs.nextInt();
                tree.get(par).add(i);
                parent.put(i, par);
            }

            // build level wise structure
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            while (!q.isEmpty()) {
                int len = q.size();
                lvl_tree.add(new ArrayList<>());
                for (int i = 0; i < len; i++) {
                    int cur = q.poll();
                    lvl_tree.get(lvl_tree.size() - 1).add(cur);
                    for (int child : tree.get(cur)) {
                        q.offer(child);
                    }
                }
            }

            for (int i = lvl_tree.size() - 1; i >= 0; i--) {
                dfs(i);
            }

            System.out.println(comp_sum.get(0));
        }
    }

    public static void dfs(int idx) {
        HashMap<Integer, Long> copy = new HashMap<>();
        long next_sum = 0;
        for (int node : lvl_tree.get(idx)) {
            long sum = 1;

            if (node == 1) {
                sum = (sum + prev_sum + mod) % mod;
            } else {
                sum = (sum + prev_sum - (comp_sum.containsKey(node) ? comp_sum.get(node) : 0) + mod) % mod;
            }

            copy.put(parent.get(node), (copy.getOrDefault(parent.get(node), 0L) + sum + mod) % mod);
            next_sum = (next_sum + sum) % mod;
        }

        prev_sum = next_sum;
        comp_sum = copy;
    }

    /*
     * find all the valid sequences
     * 
     * for a vertices i check how many sequence and start from this vertex
     * 
     * so for a vertic ans is no of vertices it can attach itself to and itself
     * assuming this the end
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