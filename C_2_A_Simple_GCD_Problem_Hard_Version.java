import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_2_A_Simple_GCD_Problem_Hard_Version {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long a[] = new long[n];
            long b[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
            }
            for (int i = 0; i < n; i++) {
                b[i] = fs.nextLong();
            }

            int prime[] = { 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67 };
            long dp[][] = new long[n][20];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }

            boolean vis[] = new boolean[n];
            for (int i = 0; i < n; i++) {
                long v = 1;
                if (i > 0)
                    v = lcm(v, gcd(a[i], a[i - 1]));
                if (i < n - 1)
                    v = lcm(v, gcd(a[i], a[i + 1]));

                if (v != a[i] && v <= b[i]) {
                    a[i] = v;
                    vis[i] = true;
                }
            }

            for (int i = 0; i < n; i++) {
                long v = 1;
                if (i > 0)
                    v = lcm(v, gcd(a[i], a[i - 1]));
                if (i < n - 1)
                    v = lcm(v, gcd(a[i], a[i + 1]));

                long best = -1;
                if (i > 0)
                    for (int p_idx = 0; p_idx < 20; p_idx++) {
                        int p = prime[p_idx];
                        if (dp[i - 1][p_idx] != -1 && gcd(a[i], p * a[i - 1]) == gcd(a[i], a[i - 1])) {
                            best = max(best, dp[i - 1][p_idx]);
                        }
                    }
                else {
                    best = 0;
                }

                if (v > b[i]) {
                    dp[i][0] = best;
                    continue;
                }

                if (vis[i]) {
                    if (best != -1)
                        dp[i][0] = best + 1;
                    continue;
                }

                for (int j_idx = 0; j_idx < 20; j_idx++) {
                    int j = prime[j_idx];

                    if ((long) j * a[i] > b[i])
                        continue;

                    if (i > 0 && gcd((long) j * a[i], a[i - 1]) != gcd(a[i], a[i - 1]))
                        continue;

                    if (i < n - 1 && gcd((long) j * a[i], a[i + 1]) != gcd(a[i], a[i + 1]))
                        continue;

                    long val = -1;
                    if (i > 0) {
                        for (int k_idx = 0; k_idx < 20; k_idx++) {
                            int k = prime[k_idx];
                            if (dp[i - 1][k_idx] == -1)
                                continue;
                            if (gcd((long) j * a[i], k * a[i - 1]) == gcd(a[i], a[i - 1])) {
                                val = max(val, dp[i - 1][k_idx]);
                            }
                        }
                    } else {
                        val = 0;
                    }

                    if (val != -1) {
                        dp[i][j_idx] = (j > 1 ? 1 : 0) + val;
                    }
                }
            }

            long max = 0;
            for (int i = 0; i < 20; i++)
                max = max(dp[n - 1][i], max);

            System.out.println(max);
        }
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        long g = gcd(a, b);
        return (a / g) * b;
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