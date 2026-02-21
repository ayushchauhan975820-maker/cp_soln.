import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Sending_a_Sequence_Over_the_Network {
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
            boolean dp[] = new boolean[n + 1];
            dp[0] = true;
            // dpi -> is it pos it fill i with some prefix or suffix
            for (int i = 1; i <= n; i++) {
                // if dp[i - 1] true then its valid to make complete
                if (i + (long) a[i] <= n && dp[i - 1]) {
                    dp[i + a[i]] = true;
                }

                // check suffix
                if (i - (long) a[i] - 1 >= 0 && dp[i - a[i] - 1]) {
                    dp[i] = true;
                }
            }

            if (dp[n])
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    /*
     * for first and lst we know all the available pos
     * for f -> 1 or all pos where i = a[i]
     * for s -> n or n - i = a[i]
     * 
     * 1 - 6 8 - 6
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