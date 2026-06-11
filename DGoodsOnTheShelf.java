import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class DGoodsOnTheShelf {
    static final int mod = (int) 1e9 + 7;
    public static int n;
    public static int a[];
    public static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }

            solve();
        }
    }

    public static void solve() {
        map = new HashMap<>();
        HashSet<Integer> vis = new HashSet<>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        boolean valid = true;
        int tot = map.size();
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i++) {
            if (i > 0 && a[i] == a[i - 1]) {
                dsu.union(i, i - 1);
            }

            if (i < n - 1 && a[i] == a[i + 1]) {
                dsu.union(i, i + 1);
            }
        }
        int f = -1;
        int s = -1;
        for (int i = 0; i < n; i++) {
            int sz = dsu.getSize(i);
            if (sz == map.get(a[i])) {
                if (!vis.contains(a[i])) {
                    vis.add(a[i]);
                    tot--;
                }
            } else {
                if (f == -1)
                    f = a[i];
                else if (a[i] != f && s == -1)
                    s = a[i];
            }
        }

        if (tot == 0) {
            System.out.println("YES");
            return;
        }
        if (tot > 2) {
            System.out.println("NO");
            return;
        }

        valid = false;
        if (tot == 1) {
            ArrayList<int[]> blocks = new ArrayList<>();
            int l = -1;
            int r = -1;

            for (int i = 0; i < n; i++) {
                if (a[i] == f) {
                    if (l == -1) {
                        l = i;
                        r = i;
                    } else {
                        r = i;
                    }
                } else {
                    if (l != -1) {
                        blocks.add(new int[] { l, r });
                        l = -1;
                        r = -1;
                    }
                }
            }
            if (l != -1) {
                blocks.add(new int[] { l, r });
                l = -1;
                r = -1;
            }
            if (blocks.size() > 3) {
                System.out.println("NO");
                return;
            }
            ArrayList<Integer> l1 = new ArrayList<>();
            ArrayList<Integer> l2 = new ArrayList<>();
            for (int[] arr : blocks) {
                int st = arr[0];
                int ed = arr[1];
                if (st - 1 >= 0)
                    l2.add(st - 1);
                if (ed + 1 < n)
                    l2.add(ed + 1);

                l1.add(st);
                l1.add(ed);
            }

            for (int idx1 : l1) {
                for (int idx2 : l2) {
                    if (idx1 == idx2)
                        continue;

                    boolean chk = check(idx1, idx2);
                    if (chk)
                        valid = true;
                }
            }
        }

        if (tot == 2) {
            ArrayList<int[]> bf = new ArrayList<>();
            ArrayList<int[]> bs = new ArrayList<>();
            int l = -1;
            int r = -1;
            int lst = -1;
            for (int i = 0; i < n; i++) {
                if (a[i] == f || a[i] == s) {
                    if (a[i] == f) {
                        if (lst == f)
                            r = i;
                        else if (lst == s) {
                            bs.add(new int[] { l, r });
                            l = i;
                            r = i;
                        } else {
                            l = i;
                            r = i;
                        }
                    } else {
                        if (lst == s)
                            r = i;
                        else if (lst == f) {
                            bf.add(new int[] { l, r });
                            l = i;
                            r = i;
                        } else {
                            l = i;
                            r = i;
                        }
                    }
                } else {
                    if (l != -1) {
                        if (lst == f)
                            bf.add(new int[] { l, r });
                        else
                            bs.add(new int[] { l, r });

                        l = -1;
                        r = -1;
                    }
                }
                lst = a[i];
            }
            if (l != -1) {
                if (lst == f)
                    bf.add(new int[] { l, r });
                else
                    bs.add(new int[] { l, r });

                l = -1;
                r = -1;
            }

            if (bf.size() > 3 || bs.size() > 3) {
                System.out.println("NO");
                return;
            }

            ArrayList<Integer> l1 = new ArrayList<>();
            ArrayList<Integer> l2 = new ArrayList<>();
            ArrayList<Integer> l3 = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            for (int[] arr : bf) {
                int st = arr[0];
                int ed = arr[1];
                if (st - 1 >= 0)
                    set.add(st - 1);
                if (ed + 1 < n)
                    set.add(ed + 1);

                l1.add(st);
                l1.add(ed);
            }

            for (int[] arr : bs) {
                int st = arr[0];
                int ed = arr[1];
                if (st - 1 >= 0)
                    set.add(st - 1);
                if (ed + 1 < n)
                    set.add(ed + 1);

                l2.add(st);
                l2.add(ed);
            }

            for (int idx : set)
                l3.add(idx);
            for (int idx1 : l1) {
                for (int idx2 : l2) {
                    if (idx1 == idx2)
                        continue;

                    boolean chk = check(idx1, idx2);
                    if (chk)
                        valid = true;
                }
            }

            for (int idx1 : l1) {
                for (int idx2 : l3) {
                    if (idx1 == idx2)
                        continue;

                    boolean chk = check(idx1, idx2);
                    if (chk)
                        valid = true;
                }
            }

            for (int idx1 : l2) {
                for (int idx2 : l3) {
                    if (idx1 == idx2)
                        continue;

                    boolean chk = check(idx1, idx2);
                    if (chk)
                        valid = true;
                }
            }
        }

        if (valid) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean check(int st, int ed) {
        swap(st, ed);
        int ct = 0;
        int lst = -1;
        for (int i = 0; i < n; i++) {
            if (a[i] != lst) {
                if (lst != -1) {
                    int tot = map.get(lst);
                    if (ct != tot) {
                        swap(st, ed);
                        return false;
                    }
                }
                lst = a[i];
                ct = 1;
            } else {
                ct++;
            }
        }
        swap(st, ed);
        return true;
    }

    public static void swap(int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
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