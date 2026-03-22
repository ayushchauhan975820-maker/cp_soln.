import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_2_Tree_Orientation_Hard_Version {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int g[][] = new int[n + 1][n + 1];
            int a[][] = new int[n + 1][n + 1];
            int b[][] = new int[n + 1][n + 1];
            boolean valid = true;
            for (int i = 1; i <= n; i++) {
                String s = fs.next();
                for (int j = 1; j <= n; j++) {
                    if (s.charAt(j - 1) == '1')
                        g[i][j] = 1;
                    a[i][j] = g[i][j];
                    // remove reflexive relation
                    if (i == j) {
                        if (g[i][j] == 1)
                            g[i][j] = 0;
                        else
                            valid = false;
                    }
                }
            }

            // remove transitive relation
            for (int i = 1; i <= n; i++) {
                if (!valid)
                    break;
                for (int j = 1; j <= n; j++) {
                    if (i == j)
                        continue;

                    if (a[i][j] == 1 && a[j][i] == 1)
                        valid = false;

                    if (a[i][j] == 1) {
                        for (int k = 1; k <= n; k++) {
                            if (j == k)
                                continue;

                            if (a[i][k] == 0 && a[j][k] == 1)
                                valid = false;

                            if (a[j][k] == 1) {
                                g[i][k] = 0;
                            }
                        }
                    }
                }
            }

            DSU dsu = new DSU(n);

            // count edges
            int count = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    b[i][j] = g[i][j];
                    if (i == j)
                        b[i][j] = 1;

                    if (g[i][j] == 1)
                        count++;
                    if (g[i][j] == 1) {
                        dsu.union(i - 1, j - 1);
                    }
                }
            }

            // build b
            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (b[i][k] == 1 && b[k][j] == 1) {
                            b[i][j] = 1;
                        }
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (a[i][j] != b[i][j])
                        valid = false;
                }
            }

            if (!valid || count != n - 1 || dsu.components != 1) {
                System.out.println("NO");
                continue;
            }

            System.out.println("YES");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (g[i][j] == 1) {
                        System.out.println(i + " " + j);
                    }
                }
            }
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
     * transitive relation will be O(n^3)
     * if there is an edge from u to v then u can visit all the nodes that v can
     * visit
     * so
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