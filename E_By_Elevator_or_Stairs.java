import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_By_Elevator_or_Stairs {
    static final int inf = (int) 1e9;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int c = fs.nextInt();
        int a[] = new int[n - 1];
        int b[] = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            a[i] = fs.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            b[i] = fs.nextInt();
        }

        int dp[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = inf;
            dp[i][1] = inf;
        }
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i][0], Math.min(dp[i - 1][1] + a[i - 1], dp[i - 1][0] + a[i - 1]));
            dp[i][1] = Math.min(dp[i][1], Math.min(dp[i - 1][0] + c + b[i - 1], dp[i - 1][1] + b[i - 1]));
        }

        for (int i = 0; i < n; i++) {
            System.out.print(Math.min(dp[i][0], dp[i][1]) + " ");
        }
        System.out.println();
    }

    /*
     * dp[i][j] = min cost to go from i to j
     * dp[i][j] = min cost of going from dp
     * to reach j and from j to i
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