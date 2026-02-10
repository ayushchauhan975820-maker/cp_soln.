import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class F_Alex_s_whims {
    static final int mod = (int) 1e9 + 7;
    public static ArrayList<HashSet<Integer>> list;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int q = fs.nextInt();
            list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(new HashSet<>());
            }
            for (int i = 1; i < n; i++) {
                System.out.println(i + " " + (i + 1));
                list.get(i).add(i + 1);
                list.get(i + 1).add(i);
            }

            int lst_fst = n;
            int lst_sec = 2;
            for (int i = 0; i < q; i++) {
                int di = fs.nextInt();
                int dist = dis(3, lst_fst, -1) + 2;
                int need = di - dist;
                if (need == 0) {
                    System.out.println("-1 -1 -1");
                } else if (need < 0) {
                    // cut something from fst
                    int pre = -1;
                    int cur = lst_fst;
                    for (int ct = 1; ct <= abs(need); ct++) {
                        for (int node : list.get(cur)) {
                            if (node == pre)
                                continue;
                            pre = cur;
                            cur = node;
                            break;
                        }
                    }
                    list.get(cur).remove(pre);
                    list.get(pre).remove(cur);
                    list.get(lst_sec).add(pre);
                    list.get(pre).add(lst_sec);
                    System.out.println(pre + " " + cur + " " + lst_sec);
                    lst_sec = lst_fst;
                    lst_fst = cur;
                } else {
                    // cut something from sec
                    int pre = -1;
                    int cur = lst_sec;
                    for (int ct = 1; ct <= abs(need); ct++) {
                        for (int node : list.get(cur)) {
                            if (node == pre)
                                continue;
                            pre = cur;
                            cur = node;
                            break;
                        }
                    }
                    list.get(cur).remove(pre);
                    list.get(pre).remove(cur);
                    list.get(lst_fst).add(pre);
                    list.get(pre).add(lst_fst);
                    System.out.println(pre + " " + cur + " " + lst_fst);
                    lst_fst = lst_sec;
                    lst_sec = cur;
                }
            }
        }
    }

    public static int dis(int x, int y, int par) {
        if (x == y)
            return 0;

        for (int node : list.get(x)) {
            if (node != par) {
                int d = dis(node, y, x);
                if (d != -1) {
                    return d + 1;
                }
            }
        }
        return -1;
    }

    /*
     * so its about distance b/w leaves
     * try this structure (fix a node and if need to inc dis then remove form
     * lst-sec and add to fst-sec and
     * vice versa)
     * 1 - 2 - 3
     * |
     * a
     * |
     * b
     * |
     * c
     * |
     * .
     * 
     * 
     * it would be 0(n) per query
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