import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Product_Queries {
    static final int mod = (int) 1e9 + 7;
    public static int inf = (int) (1e9);

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            boolean hs_one = false;
            for (int i = 0; i < n; i++) {
                int val = fs.nextInt();
                if (val == 1)
                    hs_one = true;
                else if (val <= n)
                    a.add(val);

            }
            ArrayList<Integer> list = new ArrayList<>();
            Collections.sort(a);
            for (int val : a) {
                if (list.isEmpty() || list.get(list.size() - 1) != val) {
                    list.add(val);
                }
            }

            long dp[] = new long[n + 1];
            Arrays.fill(dp, inf);
            dp[1] = (hs_one) ? 1 : inf;

            for (int val : list) {
                dp[val] = 1;
            }

            for (int i = 2; i <= n; i++) {
                if (dp[i] == inf)
                    continue;

                for (int x : list) {
                    if ((long) i * x > n)
                        break;

                    int next = i * x;
                    dp[next] = Math.min(dp[next], dp[i] + 1);
                }
            }

            for (int i = 1; i <= n; i++) {
                if (dp[i] == inf) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(dp[i] + " ");
                }
            }
            System.out.println();
        }
    }

    /*
     * 
     * so for checking if pos we need factorization
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