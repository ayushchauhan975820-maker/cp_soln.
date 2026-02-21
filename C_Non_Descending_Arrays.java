import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Non_Descending_Arrays {
    static final int mod = (int) 998244353;
    public static int n, a[], b[], dp[][];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            a = new int[n + 1];
            b = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                b[i] = fs.nextInt();
            }

            dp = new int[n + 2][2];
            for (int i = 0; i <= n + 1; i++) {
                Arrays.fill(dp[i], -1);
            }

            int ans = calc(1, 0);
            System.out.println(ans);
        }
    }

    public static int calc(int pos, int state) {
        if (pos == n + 1)
            return 1;

        if (dp[pos][state] != -1)
            return dp[pos][state];

        int ans = 0;
        if (state == 1) {
            if (a[pos - 1] <= b[pos] && b[pos - 1] <= a[pos]) {
                ans = (ans + calc(pos + 1, 0)) % mod;
            }
            if (a[pos - 1] <= a[pos] && b[pos - 1] <= b[pos]) {
                ans = (ans + calc(pos + 1, 1)) % mod;
            }
        } else {
            if (a[pos - 1] <= b[pos] && b[pos - 1] <= a[pos]) {
                ans = (ans + calc(pos + 1, 1)) % mod;
            }
            if (a[pos - 1] <= a[pos] && b[pos - 1] <= b[pos]) {
                ans = (ans + calc(pos + 1, 0)) % mod;
            }
        }
        return dp[pos][state] = ans;
    }

    /*
     * so we can swap to arrays
     * first every subarray must be sorted
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