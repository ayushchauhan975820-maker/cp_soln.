import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C1MapleAndTreeBeautyEasyVersion {
    static final int mod = (int) 1e9 + 7;
    public static ArrayList<ArrayList<Integer>> tree;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int zc = fs.nextInt();
            int oc = n - zc;

            tree = new ArrayList<>();
            for (int i = 0; i <= n; i++)
                tree.add(new ArrayList<>());

            for (int i = 2; i <= n; i++) {
                int par = fs.nextInt();
                tree.get(par).add(i);
            }

            int depth = dfs(1);
            int sum[] = new int[depth + 1];
            bfs(sum, depth);
            for (int i = 1; i <= depth; i++) {
                sum[i] += sum[i - 1];
            }

            boolean dp[][] = new boolean[depth + 1][zc + 1];
            dp[0][0] = true;

            int mn = 0;
            for (int idx = 1; idx <= depth; idx++) {
                boolean found = false;
                for (int c = 0; c <= zc; c++) {
                    if (c - (sum[idx] - sum[idx - 1]) >= 0) {
                        dp[idx][c] = dp[idx][c] || dp[idx - 1][c - (sum[idx] - sum[idx - 1])];
                    }

                    if (oc >= sum[idx] - c) {
                        dp[idx][c] = dp[idx][c] || dp[idx - 1][c];
                    }
                    if (dp[idx][c])
                        found = true;
                }

                if (found)
                    mn = idx;
                else
                    break;
            }

            System.out.println(mn);
        }
    }

    public static int dfs(int node) {
        int depth = (int) 1e8;
        for (int child : tree.get(node)) {
            depth = min(depth, dfs(child) + 1);
        }
        return (depth == (int) 1e8) ? 1 : depth;
    }

    public static void bfs(int sum[], int depth) {
        int idx = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while (!q.isEmpty()) {
            int sz = q.size();
            if (idx <= depth)
                sum[idx++] = sz;
            for (int i = 0; i < sz; i++) {
                int node = q.poll();
                for (int child : tree.get(node)) {
                    q.offer(child);
                }
            }
        }
    }

    /*
     * length of lcs is bounded by smallest path and is binary searchable
     * 
     * how can we check if length k is valid
     * 
     * its always better to form sequence as early as possible
     * 
     * dp idx zc -> is it pos to construct tree upto level idx using exactly zc(0's)
     * 
     * dp[idx][zc] = dp[idx - 1][zc - (no. nodes at cur level)] || (dp[idx - 1][zc]
     * :
     * if oc >= (sum of all the nodes till cur level - oc))
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