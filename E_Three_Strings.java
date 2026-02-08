import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Three_Strings {
    static final int mod = (int) 1e9 + 7;
    public static String a;
    public static String b;
    public static String c;
    public static int dp[][];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            a = fs.next();
            b = fs.next();
            c = fs.next();
            dp = new int[a.length() + 1][b.length() + 1];
            for (int i = 0; i <= a.length(); i++) {
                Arrays.fill(dp[i], -1);
            }
            int ans = dfs(0, 0);
            System.out.println(ans);
        }
    }

    public static int dfs(int i, int j) {
        if (i == a.length()) {
            int res = 0;
            for (int p = j; p < b.length(); p++) {
                if (b.charAt(p) != c.charAt(p + i)) {
                    res++;
                }
            }
            return res;
        }
        if (j == b.length()) {
            int res = 0;
            for (int p = i; p < a.length(); p++) {
                if (a.charAt(p) != c.charAt(p + j)) {
                    res++;
                }
            }
            return res;
        }
        if (dp[i][j] != -1)
            return dp[i][j];

        char c1 = a.charAt(i);
        char c2 = b.charAt(j);
        char c3 = c.charAt(i + j);

        int res = 0;
        if (c1 != c3 && c2 != c3) {
            int f = dfs(i + 1, j);
            int s = dfs(i, j + 1);

            res = Math.min(f, s) + 1;
        } else if (c1 == c3 && c2 == c3) {
            int f = dfs(i + 1, j);
            int s = dfs(i, j + 1);

            res = Math.min(f, s);
        } else {
            int pa = dfs(i + 1, j) + ((a.charAt(i) == c.charAt(i + j) ? 0 : 1));
            int pb = dfs(i, j + 1) + ((b.charAt(j) == c.charAt(i + j) ? 0 : 1));

            res = Math.min(pa, pb);
        }

        return dp[i][j] = res;
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