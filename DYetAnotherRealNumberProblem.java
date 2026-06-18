import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class DYetAnotherRealNumberProblem {
    static final int mod = (int) 1e9 + 7;
    public static long pow2[] = new long[40];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        pow2[0] = 1;
        for (int i = 1; i < 40; i++) {
            pow2[i] = 2 * pow2[i - 1];
        }
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            Stack<long[]> st = new Stack<>();
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
            }
            long st_sum = 0;
            long bs_sum = 0;
            long ans[] = new long[n];
            for (int i = 0; i < n; i++) {
                long cur = a[i];
                long tot = 0;
                while (cur % 2 == 0) {
                    tot++;
                    cur /= 2;
                }
                long pow_mod_add = (1L << tot);
                while (!st.isEmpty()) {
                    long val = st.peek()[0];
                    long pow = st.peek()[1];
                    long added = st.peek()[2];
                    long pow_mod = st.peek()[3];
                    boolean big = false;

                    if (tot > 30) {
                        big = true;
                    } else if (val <= cur * (1L << tot)) {
                        big = true;
                    }

                    if (big) {
                        st.pop();
                        st_sum = (st_sum - added + mod) % mod;
                        pow_mod_add = (pow_mod_add * pow_mod) % mod;
                        bs_sum = (bs_sum + val) % mod;
                        tot += pow;
                    } else {
                        break;
                    }
                }
                long st_sum_cont = (pow_mod_add * cur) % mod;
                st_sum = (st_sum + st_sum_cont) % mod;
                ans[i] = (st_sum + bs_sum) % mod;
                st.push(new long[] { cur, tot, st_sum_cont, pow_mod_add });
            }

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
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