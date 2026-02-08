import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Reverse_the_Rivers {
    static final int mod = (int) 1e9 + 7;
    public static int pf[][];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = 1;
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int q = fs.nextInt();

            int a[][] = new int[n][k];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    a[i][j] = fs.nextInt();
                }
            }

            pf = new int[n][k];
            for (int j = 0; j < k; j++) {
                int or = 0;
                for (int i = 0; i < n; i++) {
                    or |= a[i][j];
                    pf[i][j] = or;
                }
            }

            for (int i = 0; i < q; i++) {
                int m = fs.nextInt();
                int st = 0;
                int ed = n - 1;
                boolean valid = true;
                for (int j = 0; j < m; j++) {
                    int r = fs.nextInt() - 1;
                    String sgn = fs.next();
                    int c = fs.nextInt();

                    if (st > ed)
                        continue;

                    boolean gt = sgn.equals(">");
                    int min = min_bs(st, ed, r, c, gt);
                    int max = max_bs(st, ed, r, c, gt);

                    if (min == -1 || max == -1) {
                        st = n + 1;
                        continue;
                    }

                    st = Math.max(st, min);
                    ed = Math.min(ed, max);
                }

                if (st > ed) {
                    System.out.println(-1);
                } else {
                    System.out.println(st + 1);
                }
            }
        }
    }

    public static int min_bs(int l, int r, int col, int val, boolean gt) {
        int lst = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (gt) {
                if (pf[mid][col] > val) {
                    lst = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (pf[mid][col] < val) {
                    lst = mid;
                    r = mid - 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return lst;
    }

    public static int max_bs(int l, int r, int col, int val, boolean gt) {
        int lst = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (gt) {
                if (pf[mid][col] > val) {
                    lst = mid;
                    l = mid + 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (pf[mid][col] < val) {
                    lst = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return lst;
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