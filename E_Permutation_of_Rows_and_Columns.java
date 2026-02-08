import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Permutation_of_Rows_and_Columns {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int a[][] = new int[n][m];
            int b[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = fs.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    b[i][j] = fs.nextInt();
                }
            }

            DSU row_comp = new DSU(n * m + 1);
            DSU col_comp = new DSU(n * m + 1);
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    row_comp.union(a[i][j - 1], a[i][j]);
                    row_comp.union(b[i][j - 1], b[i][j]);
                }
            }

            for (int j = 0; j < m; j++) {
                for (int i = 1; i < n; i++) {
                    col_comp.union(a[i - 1][j], a[i][j]);
                    col_comp.union(b[i - 1][j], b[i][j]);
                }
            }

            int rc = row_comp.components - 1;
            int cc = col_comp.components - 1;
            if (rc == n && cc == m) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
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
     * so every element must be in the row as well as column
     * 
     * lets make row and col dsu i.e all the elements of t
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