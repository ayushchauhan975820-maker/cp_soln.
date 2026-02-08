import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Exquisite_Array {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n];
            ArrayList<ArrayList<Integer>> dif_list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                dif_list.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }

            for (int i = 1; i < n; i++) {
                int diff = abs(a[i] - a[i - 1]);
                dif_list.get(diff).add(i);
            }
            DSU dsu = new DSU(n + 1);
            long ans[] = new long[n];
            long tot_score = 0;
            for (int i = n - 1; i >= 1; i--) {
                // activate the diff n - 1
                for (int idx : dif_list.get(i)) {
                    dsu.active[idx] = true;
                    tot_score++;
                    // activate idx check is left or right is active
                    if (dsu.active[idx - 1]) {
                        tot_score += dsu.union(idx - 1, idx);
                    }
                    if (dsu.active[idx + 1]) {
                        tot_score += dsu.union(idx + 1, idx);
                    }
                }
                ans[i] = tot_score;
            }

            for (int i = 1; i <= n - 1; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }

    // Disjoint Set Union (Union-Find)
    static class DSU {
        int[] parent;
        long[] size;
        boolean[] active;

        DSU(int n) {
            parent = new int[n];
            size = new long[n];
            active = new boolean[n];
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

        long union(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if (ra == rb)
                return 0;

            long ans = 0;
            ans -= (size[ra] * (size[ra] + 1)) / 2;
            ans -= (size[rb] * (size[rb] + 1)) / 2;

            if (size[ra] < size[rb]) {
                int t = ra;
                ra = rb;
                rb = t;
            }

            parent[rb] = ra;
            size[ra] += size[rb];
            ans += (size[ra] * (size[ra] + 1)) / 2;
            return ans;
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