import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Alice_s_Adventures_in_Cutting_Cake {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int v = fs.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }

            int idx = 0;
            int ct = 0;
            long sum = 0;
            while (idx < n) {
                sum += a[idx];
                if (sum >= v) {
                    ct++;
                    sum = 0;
                }
                if (idx == n - 1) {
                    if (sum >= v) {
                        ct++;
                        sum = 0;
                    }
                    break;
                }
                idx++;
            }
            if (ct < m) {
                System.out.println(-1);
                continue;
            }

            int sfx[] = new int[n + 1];
            long suf[] = new long[n + 1];
            suf[n - 1] = a[n - 1];
            long sm = 0;
            if (a[n - 1] >= v) {
                sfx[n - 1] = 1;
            } else {
                sfx[n - 1] = 0;
                sm += a[n - 1];
            }
            for (int i = n - 2; i >= 0; i--) {
                sm += a[i];
                suf[i] = suf[i + 1] + a[i];
                if (sm >= v) {
                    sfx[i] = sfx[i + 1] + 1;
                    sm = 0;
                } else {
                    sfx[i] = sfx[i + 1];
                }
            }
            sm = 0;
            ct = 0;
            long max = 0;
            for (int i = 0; i < n; i++) {
                sm += a[i];
                // search for the furthurest index where ct + suf[i] >= m
                int ans = -1;
                int l = i;
                int r = n;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (sfx[mid] + ct >= m) {
                        ans = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }

                if (sm >= v) {
                    sm = 0;
                    ct++;
                }

                if (ans == -1)
                    continue;

                max = Math.max(max, suf[i] - suf[ans]);
            }

            System.out.println(max);
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