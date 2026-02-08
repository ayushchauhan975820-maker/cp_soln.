import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Hungry_Games {
    static final int mod = (int) 1e9 + 7;
    public static int n, x;
    public static int a[];
    public static long suf[];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            x = fs.nextInt();
            a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
            }
            suf = new long[n + 1];
            suf[n] = a[n];
            for (int i = n - 1; i >= 1; i--) {
                suf[i] = suf[i + 1] + (long) a[i];
            }
            long dp[] = new long[n + 2];
            long cur_sum = 0;
            long ans = 0;
            for (int i = n; i >= 1; i--) {
                cur_sum += (long) a[i];

                if (cur_sum <= x) {
                    dp[i] = n - i + 1;
                    ans += dp[i];
                    continue;
                }

                long rem = cur_sum - x;
                int idx = bs(rem, i);

                dp[i] = (idx - i - 1);
                if (idx <= n) {
                    dp[i] += dp[idx];
                }
                ans += dp[i];
            }

            System.out.println(ans);
        }
    }

    public static int bs(long sum, int l) {
        int ans = n + 1;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (suf[mid] < sum) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    /*
     * all valid l and r such that f(t) != 0
     * 
     * f(i) -> is the no of subarrays starting at i that will leave non zero
     * 
     * f(i) -> len - 1 + (first idx where sum become 0 + 1) + 1 if(i <= x)
     * 
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