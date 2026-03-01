import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_2_Lost_Civilization_Hard_Version {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
            }

            long dp[] = new long[n + 1];
            long tot = 0;
            // dp[i] is the value the ans ending at i

            int k[] = new int[n + 1];
            int stack[] = new int[n + 1];
            int top = 0;

            for (int i = 1; i <= n; i++) {
                while (top > 0 && a[stack[top - 1]] >= a[i]) {
                    top--;
                }
                k[i] = (top == 0) ? 0 : stack[top - 1];
                stack[top++] = i;
            }

            long lst = 0;
            for (int i = 1; i <= n; i++) {
                if (i > 1 && a[i] > a[i - 1] && a[i] - a[i - 1] != 1) {
                    lst = i;
                }

                int prev;
                if (lst >= k[i] + 1) {
                    prev = 1;
                } else {
                    prev = k[i] + 1;
                }

                long tot_fail = i - prev + 1;
                dp[i] = dp[i - 1] + tot_fail;
                tot += dp[i];
            }

            System.out.println(tot);
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