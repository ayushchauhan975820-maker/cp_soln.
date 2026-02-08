import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Graph_Composition {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m1 = fs.nextInt();
            int m2 = fs.nextInt();
            HashMap<Integer, ArrayList<Integer>> f = new HashMap<>();
            for (int i = 0; i < m1; i++) {
                int u = fs.nextInt();
                int v = fs.nextInt();
                if (!f.containsKey(u)) {
                    f.put(u, new ArrayList<>());
                }
                f.get(u).add(v);
                if (!f.containsKey(v)) {
                    f.put(v, new ArrayList<>());
                }
                f.get(v).add(u);
            }
            HashMap<Integer, ArrayList<Integer>> s = new HashMap<>();
            DSU dsu = new DSU(n + 1);
            for (int i = 0; i < m2; i++) {
                int u = fs.nextInt();
                int v = fs.nextInt();
                if (!s.containsKey(u)) {
                    s.put(u, new ArrayList<>());
                }
                s.get(u).add(v);
                if (!s.containsKey(v)) {
                    s.put(v, new ArrayList<>());
                }
                s.get(v).add(u);
                if (!dsu.connected(u, v)) {
                    dsu.union(u, v);
                }
            }
            DSU dsu2 = new DSU(n + 1);
            long ct = 0;
            for (int u : f.keySet()) {
                for (int v : f.get(u)) {
                    if (u < v) {
                        if (!dsu.connected(u, v))
                            ct++;
                        else
                            dsu2.union(u, v);
                    }
                }
            }

            HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                int rootS = dsu.find(i);
                int rootF = dsu2.find(i);
                map.computeIfAbsent(rootS, k -> new HashSet<>()).add(rootF);
            }

            int extra = 0;
            for (int idx : map.keySet()) {
                extra += (map.get(idx).size() - 1);
            }

            System.out.println(ct + extra);
        }
    }

    /*
    
    
    */

    // ---- helper ----
    // Disjoint Set Union (Union-Find)
    static class DSU {
        int[] parent;
        int[] size;
        int components;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
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