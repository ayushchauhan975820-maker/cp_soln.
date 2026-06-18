import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class FWildflower {
    static final int mod = (int) 1e9 + 7;
    public static ArrayList<Integer> tree[];
    public static int parent[];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            tree = new ArrayList[n + 1];
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++)
                tree[i] = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                int u = fs.nextInt();
                int v = fs.nextInt();
                tree[u].add(v);
                tree[v].add(u);
            }
            build(1, 0);
            for (int i = 0; i <= n; i++)
                tree[i] = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                tree[parent[i]].add(i);
            }
            int leaf = 0;
            for (int i = 1; i <= n; i++) {
                if (tree[i].size() == 0)
                    leaf++;
            }
            long ans = 1;
            if (leaf > 2) {
                ans = 0;
            } else if (leaf == 1) {
                for (int i = 0; i < n; i++) {
                    ans = (ans * 2) % mod;
                }
            } else {
                int target = 0;
                for (int i = 1; i <= n; i++) {
                    if (tree[i].size() == 2) {
                        target = i;
                        break;
                    }
                }
                int lena = dfs(1, target);
                int lenb = dfs(tree[target].get(0), -1);
                int lenc = dfs(tree[target].get(1), -1);

                for (int i = 0; i < lena; i++) {
                    ans = (ans * 2) % mod;
                }

                if (lenb < lenc) {
                    int temp = lenb;
                    lenb = lenc;
                    lenc = temp;
                }

                int dif = lenb - lenc;
                if (dif == 0) {
                    ans = (ans * 2) % mod;
                } else {
                    long ls = 1;
                    for (int i = 0; i < dif - 1; i++) {
                        ls = (ls * 2) % mod;
                    }

                    long var = (ls + ((ls * 2) % mod)) % mod;
                    ans = (ans * var) % mod;
                }
            }

            System.out.println(ans);
        }
    }

    public static int dfs(int node, int target) {
        if (node == target)
            return 1;
        int ans = 1;
        for (int child : tree[node]) {
            ans += dfs(child, target);
        }
        return ans;
    }

    public static void build(int node, int par) {
        parent[node] = par;
        for (int child : tree[node]) {
            if (child != par)
                build(child, node);
        }
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