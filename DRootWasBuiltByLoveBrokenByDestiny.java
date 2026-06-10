import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class DRootWasBuiltByLoveBrokenByDestiny {
    static final long mod = (long) 1e9 + 7;
    public static long fact[] = new long[200006];
    public static ArrayList<ArrayList<Integer>> tree;

    public static void calc() {
        fact[0] = 1;
        for (int i = 1; i <= 200005; i++) {
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
            tree = new ArrayList<>();
            DSU dsu = new DSU(n);
            boolean valid = true;
            for (int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int u = fs.nextInt();
                int v = fs.nextInt();
                tree.get(u).add(v);
                tree.get(v).add(u);

                if (dsu.find(u - 1) == dsu.find(v - 1)) {
                    valid = false;
                } else {
                    dsu.union(u - 1, v - 1);
                }
            }

            int comp = dsu.components;
            long ans = 1;
            for (int i = 0; i < comp; i++) {
                ans = (ans * 2) % mod;
            }
            long plr = 0;
            int perm[] = new int[n + 1];
            int ct[][] = new int[n + 1][2];
            for (int i = 1; i <= n; i++) {
                if (tree.get(i).size() > 1) {
                    perm[i] = 1;
                    plr++;
                }
            }
            for (int i = 1; i <= n; i++) {
                if (perm[i] == 0)
                    continue;
                int light = 0;
                int heavy = 0;
                for (int node : tree.get(i)) {
                    if (perm[node] == 0)
                        light++;
                    else
                        heavy++;
                }

                if (heavy > 2)
                    valid = false;
                ct[i][0] = light;
                ct[i][1] = heavy;
            }

            if (!valid) {
                ans = 0;
            }
            if (plr >= 2) {
                ans = (ans * 2) % mod;
            }
            for (int i = 1; i <= n; i++) {
                if (perm[i] == 0)
                    continue;
                ans = (ans * fact[ct[i][0]]) % mod;
            }

            System.out.println(ans);
        }
    }

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

    /*
     * bridges stays b/w u and v in every arrangement
     * conditions (atleast 1)
     * if atleast 2 houses has swapped sides
     * ordering of house h1 and h2
     * 
     * divided into components and can rotate
     * for a node with two or more child only the outer onces are supposed to have
     * extrabridges
     * outer onces can only be rotated with each other
     * inner onces can be in any form(inner onces can't have extrabridges)
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