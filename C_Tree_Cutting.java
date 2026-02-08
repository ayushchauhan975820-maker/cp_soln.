import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Tree_Cutting {
    static final int mod = (int) 1e9 + 7;
    public static ArrayList<ArrayList<Integer>> tree;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();

            tree = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }
            for (int i = 0; i < n - 1; i++) {
                int u = fs.nextInt();
                int v = fs.nextInt();
                tree.get(u).add(v);
                tree.get(v).add(u);
            }
            int l = 1;
            int r = n / k;
            int ans = 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;

                int a[] = valid(1, 0, mid);
                boolean val = (a[1] > k) || (a[1] == k && a[0] >= mid);
                if (val) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            System.out.println(ans);
        }
    }

    public static int[] valid(int node, int par, int x) {
        // find size of the all the neigh nodes
        int size = 1;
        int k = 0;
        for (int neigh : tree.get(node)) {
            if (neigh == par)
                continue;

            int arr[] = valid(neigh, node, x);
            k += arr[1];
            if (arr[0] >= x) {
                // cut the edge
                k++;
            } else {
                // add to the cur comp
                size += arr[0];
            }
        }

        return new int[] { size, k };
    }

    /*
    
    
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