import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Climbing_the_Tree {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int q = fs.nextInt();
            long cur_rng[] = { -1, -1 };
            for (int i = 0; i < q; i++) {
                long ev = fs.nextInt();
                long a = fs.nextInt();
                long b = fs.nextInt();
                long dif = a - b;
                if (ev == 1) {
                    int n = fs.nextInt();
                    long mul = (long) dif * (n - 1);
                    long nxt_rng[] = { (n == 1) ? 1 : (long) (n - 2) * dif + a + 1, mul + a };
                    if (cur_rng[0] == -1) {
                        cur_rng = nxt_rng;
                        System.out.print(1 + " ");
                    } else {
                        // intersect
                        long low = max(cur_rng[0], nxt_rng[0]);
                        long high = min(cur_rng[1], nxt_rng[1]);

                        if (low > high) {
                            System.out.print(0 + " ");
                        } else {
                            cur_rng = new long[] { low, high };
                            System.out.print(1 + " ");
                        }
                    }
                } else {
                    if (cur_rng[0] == -1) {
                        System.out.print(-1 + " ");
                    } else {
                        long nxt_ht_min = cur_rng[0] - a;
                        long nxt_ht_max = cur_rng[1] - a;
                        long days_min = max(0, (nxt_ht_min + dif - 1) / dif) + 1;
                        long days_max = max(0, (nxt_ht_max + dif - 1) / dif) + 1;

                        if (days_max == days_min)
                            System.out.print(days_max + " ");
                        else
                            System.out.print(-1 + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    /*
     * in n - 1 days sn will climb
     * dist = (a - b) * n - 1
     * then on the nth day it will reach [dist + 1 to dist + a]
     * 
     * for height intersect all such type 1 query
     * 
     * for type 2
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