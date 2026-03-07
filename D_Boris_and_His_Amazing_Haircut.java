import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Boris_and_His_Amazing_Haircut {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n + 1];
            int b[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
            }
            boolean valid = true;
            for (int i = 1; i <= n; i++) {
                b[i] = fs.nextInt();
                if (b[i] > a[i])
                    valid = false;
            }
            TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
            for (int i = 1; i <= n; i++) {
                // if(a[i] == b[i]) continue;
                if (!map.containsKey(b[i])) {
                    map.put(b[i], new ArrayList<>());
                }

                map.get(b[i]).add(i);
            }

            HashMap<Integer, Integer> blade_ct = new HashMap<>();
            int m = fs.nextInt();
            for (int i = 0; i < m; i++) {
                int sharpness = fs.nextInt();
                blade_ct.put(sharpness, blade_ct.getOrDefault(sharpness, 0) + 1);
            }

            if (!valid) {
                System.out.println("NO");
                continue;
            }

            DSU dsu = new DSU(n + 1);
            for (int val : map.keySet()) {
                ArrayList<Integer> indexes = map.get(val);
                for (int index : indexes) {
                    if (index != 1) {
                        if (b[index - 1] <= b[index]) {
                            dsu.union(index - 1, index);
                        }
                    }
                    if (index != n) {
                        if (b[index] >= b[index + 1]) {
                            dsu.union(index, index + 1);
                        }
                    }
                }

                // find out the no of components and then find out which components need a blade
                // if any component has any bad index then it needs a blade
                HashSet<Integer> parent = new HashSet<>();
                for (int index : indexes) {
                    if (a[index] == b[index])
                        continue;
                    parent.add(dsu.find(index));
                }

                int blade_av = blade_ct.containsKey(val) ? blade_ct.get(val) : 0;
                if (blade_av < parent.size()) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
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
     * if bi > ai then its -1
     * 
     * color only blocks that need to be colored from smallest to largest
     * as large can use small as connectors and small become invariant for that
     * large one
     * 
     * min(ai, x) if a big no is colored using smaller it can never be colored back
     * so
     * no of components of x must be less then or equal to no of blades available
     * 
     * 
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