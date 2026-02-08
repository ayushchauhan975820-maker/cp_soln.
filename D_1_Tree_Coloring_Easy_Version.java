import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_1_Tree_Coloring_Easy_Version {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
            }
            for (int i = 0; i < n - 1; i++) {
                int u = fs.nextInt() - 1;
                int v = fs.nextInt() - 1;
                list.get(u).add(v);
                list.get(v).add(u);
            }

            boolean vis[] = new boolean[n];
            Queue<int[]> q = new LinkedList<>();
            int ans = 0;
            q.offer(new int[] { 0, -1 });
            vis[0] = true;
            while (!q.isEmpty()) {
                int sz = q.size();
                int par = q.peek()[1];
                boolean smpr = true;
                for (int i = 0; i < sz; i++) {
                    int[] cur = q.poll();
                    if (cur[1] != par)
                        smpr = false;

                    for (int j = 0; j < list.get(cur[0]).size(); j++) {
                        if (!vis[list.get(cur[0]).get(j)]) {
                            q.offer(new int[] { list.get(cur[0]).get(j), cur[0] });
                            vis[list.get(cur[0]).get(j)] = true;
                        }
                    }
                }
                ans = Math.max(ans, sz + ((smpr) ? 1 : 0));
            }

            System.out.println(ans);
        }
    }

    /*
     * all the nodes on a lvl must be handled seperately
     * if all the nodes have a single par then max + 1
     * else max
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