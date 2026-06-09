import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class DAvoidMinimums {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long k = fs.nextLong();
            long a[] = new long[n];
            long mx = 0;
            long lw = (long) 1e18;
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
                mx = Math.max(mx, a[i]);
                lw = Math.min(lw, a[i]);
            }

            long mn = 0;
            long ct = 0;
            for (int i = 0; i < n; i++) {
                mn += mx - a[i];
                if (a[i] == lw)
                    ct++;
            }

            if (mn > k) {
                System.out.println(-1);
                continue;
            }

            long val = mx + (k - mn) / n;
            long ans = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] != lw) {
                    ans += val - a[i];
                }
            }

            ans += max(0L, ct - 1) * max(0L, val - lw - 1);

            System.out.println(ans);
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