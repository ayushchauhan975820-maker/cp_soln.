import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class G_The_67_th_Iteration_of_Counting_is_Fun {
    static final long mod = (long) 676767677;
    public static long fact[] = new long[100001];

    public static void calc() {
        fact[1] = 1;
        fact[0] = 1;
        for (int i = 2; i <= 100000; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        calc();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int b[] = new int[n];
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                list.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                b[i] = fs.nextInt();
                list.get(b[i]).add(i);
            }
            DSU dsu = new DSU(n);
            long ans = 1;
            int tot = 0;
            for (int i = 0; i < list.get(0).size(); i++) {
                int idx = list.get(0).get(i);
                dsu.vis[idx] = true;
                if (idx > 0 && dsu.vis[idx - 1])
                    dsu.union(idx - 1, idx);
                if (idx < n - 1 && dsu.vis[idx + 1])
                    dsu.union(idx, idx + 1);
            }

            int time[] = new int[m];
            boolean valid = true;
            time[0] = (list.get(0).size());
            tot += list.get(0).size();
            for (int i = 1; i < m && valid; i++) {
                int ct = list.get(i).size();
                ArrayList<Integer> cur = list.get(i);

                for (int idx : cur) {
                    if (!(idx > 0 && dsu.vis[idx - 1]) && !(idx < n - 1 && dsu.vis[idx + 1])) {
                        valid = false;
                        break;
                    }
                }

                for (int idx : cur) {
                    int left_idx = 1;
                    int right_idx = 1;
                    if (idx > 0 && b[idx] - b[idx - 1] > 1)
                        left_idx = time[i - 2] + 1;
                    if (idx < n - 1 && b[idx] - b[idx + 1] > 1)
                        right_idx = time[i - 2] + 1;
                    int lwr_bound = Math.max(left_idx, right_idx);

                    int upr_bound = tot;

                    int dif = upr_bound - lwr_bound + 1;
                    // fact
                    ans = (ans * dif) % mod;
                }
                tot += ct;

                time[i] = tot;
                for (int idx : cur) {
                    if (idx > 0 && dsu.vis[idx - 1]) {
                        dsu.union(idx - 1, idx);
                    }
                    if (idx < n - 1 && dsu.vis[idx + 1]) {
                        dsu.union(idx + 1, idx);
                    }
                }
            }

            if (!valid) {
                System.out.println(0);
            } else {
                System.out.println(ans);
            }
        }
    }

    // Disjoint Set Union (Union-Find)
    static class DSU {
        int[] parent;
        int[] size;
        boolean[] vis;
        int components;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            vis = new boolean[n];
            components = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if (ra == rb)
                return false;

            if (size[ra] < size[rb]) {
                int t = ra;
                ra = rb;
                rb = t;
            }

            parent[rb] = ra;
            size[ra] += size[rb];
            components--;
            vis[a] = true;
            vis[b] = true;
            return true;
        }

        boolean connected(int a, int b) {
            return find(a) == find(b);
        }

        int getSize(int x) {
            return size[find(x)];
        }

        int count() {
            return components;
        }
    }

    /*
     * groups will be formed
     * some elements can be anything and some are forced to follow a group
     * 
     * x grp
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