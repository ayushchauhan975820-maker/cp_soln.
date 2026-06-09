import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class FItJustKeepsGoingSideways {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n + 1];
            int max = 0;
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
                max = Math.max(max, a[i]);
            }
            int ct[] = new int[max + 1];
            int suf[] = new int[max + 1];

            long ans = 0;
            for (int i = n; i >= 1; i--) {
                int val = a[i];
                ct[val]++;
                // first pos of values
                if (suf[val] == 0)
                    suf[val] = i;
            }

            for (int i = max - 1; i >= 0; i--) {
                ct[i] += ct[i + 1];
            }

            long max_added = 0;
            int idx = 0;
            for (int i = 1; i <= n; i++) {
                int val = a[i];
                if (suf[val] != i)
                    continue;
                int nw_added = (ct[val] - 1) - (n - i);
                if (nw_added > max_added) {
                    max_added = nw_added;
                    idx = i;
                }
            }
            ct[a[idx]]--;
            a[idx]--;

            for (int i = 1; i <= n; i++) {
                int val = a[i];
                ans += ((long) val * (long) (n + 1 - i));
            }

            for (int i = 1; i <= max; i++) {
                int count = ct[i];
                ans -= ((long) (count + 1) * (long) count) / 2;
            }

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