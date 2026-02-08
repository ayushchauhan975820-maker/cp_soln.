import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Median_Splits {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }

            int pre[] = new int[n];
            int suf[] = new int[n];
            pre[0] = (a[0] <= k) ? 1 : 0;
            for (int i = 1; i < n; i++) {
                pre[i] = pre[i - 1] + ((a[i] <= k) ? 1 : 0);
            }

            suf[n - 1] = (a[n - 1] <= k) ? 1 : 0;
            for (int i = n - 2; i >= 0; i--) {
                suf[i] = suf[i + 1] + ((a[i] <= k) ? 1 : 0);
            }

            int ct = 0;
            int last = -1;
            // find prefix
            for (int i = 0; i < n - 1; i++) {
                int last_pre = (last == -1) ? 0 : pre[last];
                int el_contains = pre[i] - last_pre;
                int range = i - last;
                if (el_contains >= (range + 1) / 2) {
                    if (range % 2 != 0 && a[i + 1] > k) {
                        last = i + 1;
                        i++;
                    }
                    ct++;
                }
            }

            if (ct >= 2) {
                System.out.println("YES");
                continue;
            }

            ct = 0;
            last = n;
            // find suffix
            for (int i = n - 1; i >= 1; i--) {
                int prev_suf = (last == n) ? 0 : suf[last];
                int el_contains = suf[i] - prev_suf;
                int range = last - i;
                if (el_contains >= (range + 1) / 2) {
                    if (range % 2 != 0 && a[i - 1] > k) {
                        last = i + 1;
                        i--;
                    }
                    ct++;
                }
            }

            if (ct >= 2) {
                System.out.println("YES");
                continue;
            }

            // try sideways with two p
            int l = 0;
            int r = n - 1;
            while (l < n) {
                int range = l + 1;
                int el_contains = pre[l];
                if (el_contains >= (range + 1) / 2) {
                    break;
                }
                l++;
            }
            while (r >= 0) {
                int range = n - r;
                int el_contains = suf[r];
                if (el_contains >= (range + 1) / 2) {
                    break;
                }
                r--;
            }

            if (r - l >= 2) {
                System.out.println("YES");
                continue;
            }

            System.out.println("NO");
        }
    }

    /*
     * if first and last are less than or equal to k then always possible
     * so we can greedily choose to make x and y better for that we need x/2
     * half + (num%2);<= k
     * need some prefix and suffix with this condition if the overlap its no else
     * yes
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