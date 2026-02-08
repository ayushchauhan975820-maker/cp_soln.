import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Elections {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int c = fs.nextInt();
            long ans[] = new long[n + 1];
            Arrays.fill(ans, mod);
            int fst = 1;
            long a[] = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                int val = fs.nextInt();
                a[i] = val;
            }
            long pre[] = new long[n + 1];
            pre[1] = a[1];
            for (int i = 2; i <= n; i++) {
                pre[i] = pre[i - 1] + a[i];
                if (fst == 1) {
                    if (a[i] > a[fst] + (long) c)
                        fst = i;
                } else {
                    if (a[i] > a[fst])
                        fst = i;
                }
            }
            ans[fst] = 0;
            int suf[] = new int[n + 2];
            suf[n] = n;
            for (int i = n - 1; i >= 1; i--) {
                if (a[i] >= a[suf[i + 1]]) {
                    suf[i] = i;
                } else {
                    suf[i] = suf[i + 1];
                }
            }

            // remove all the elements from the right and if needed majority from the left
            for (int i = 1; i <= n; i++) {
                long val = a[i];
                long sm_left = pre[i - 1] + c;
                long maj_right = a[suf[i + 1]];

                if (val + sm_left >= maj_right) {
                    ans[i] = min(ans[i], i - 1);
                } else {
                    ans[i] = min(ans[i], i);
                }
            }

            for (int i = 1; i <= n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }

    /*
     * 
     * * we need majority votes
     * for that what we can do is
     * remove all the major elements
     * or make it lst element and remove some bigger el
     * remove all the elements greater than this or remove all the elements from the
     * left and all the elements
     * greater than this from the right
     * 
     * if our sum is x if majority on left is y we at
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