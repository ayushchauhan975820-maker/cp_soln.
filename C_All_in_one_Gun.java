import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_All_in_one_Gun {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int h = fs.nextInt();
            int k = fs.nextInt();
            int a[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
            }

            long prefix[] = new long[n + 1];
            int mn[] = new int[n + 1];
            mn[0] = Integer.MAX_VALUE;
            int mx[] = new int[n + 2];
            mx[n] = a[n];
            for (int i = n - 1; i >= 1; i--) {
                mx[i] = max(mx[i + 1], a[i]);
            }
            for (int i = 1; i <= n; i++) {
                prefix[i] = prefix[i - 1] + a[i];
                mn[i] = min(mn[i - 1], a[i]);
            }

            long time = Long.MAX_VALUE;
            if (h % prefix[n] == 0) {
                long times = h / prefix[n];
                time = min(time, (times - 1) * ((long) n + k) + n);
            }
            for (int i = 1; i <= n; i++) {
                // assume i to be the last index it health reaches 0
                long times = h / prefix[n];
                long health_left = h - times * prefix[n];
                if (i < n && prefix[i] - mn[i] + mx[i + 1] >= health_left) {
                    time = min(time, times * ((long) n + k) + i);
                }
                if (prefix[i] >= health_left) {
                    time = min(time, times * ((long) n + k) + i);
                }
            }

            System.out.println(time);
        }
    }

    /*
     * if health becomes less then x
     * 
     * for some prefix
     * find some prefix and suffix
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