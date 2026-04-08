import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class F_Bouncy_Ball {
    static final int mod = (int) 1e9 + 7;
    public static boolean dp[][][];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int i = fs.nextInt() - 1;
            int j = fs.nextInt() - 1;
            int ti = fs.nextInt() - 1;
            int tj = fs.nextInt() - 1;
            String cell = fs.next();
            dp = new boolean[n][m][4];
            int dirr = (cell.charAt(0) == 'D') ? 1 : -1;
            int dirc = (cell.charAt(1) == 'R') ? 1 : -1;

            int ans = dfs(n, m, i, j, ti, tj, dirr, dirc);
            System.out.println(ans < 0 ? -1 : ans);
        }
    }

    public static int get_dir(int dirx, int diry) {
        if (dirx == 1 && diry == 1)
            return 3;
        if (dirx == -1 && diry == -1)
            return 0;
        if (dirx == -1 && diry == 1)
            return 1;
        if (dirx == 1 && diry == -1)
            return 2;

        return -1;
    }

    public static int dfs(int n, int m, int i, int j, int ti, int tj, int dirr, int dirc) {
        if (i == ti && j == tj)
            return 0;
        int dirn = get_dir(dirr, dirc);
        if (dirn < 0 || dp[i][j][dirn])
            return Integer.MIN_VALUE;

        dp[i][j][dirn] = true;

        // full
        if (i == 0 && j == 0 && dirn == 0) {
            return dfs(n, m, i, j, ti, tj, dirr * -1, dirc * -1) + 1;
        } else if (i == 0 && j == m - 1 && dirn == 1) {
            return dfs(n, m, i, j, ti, tj, dirr * -1, dirc * -1) + 1;
        } else if (i == n - 1 && j == 0 && dirn == 2) {
            return dfs(n, m, i, j, ti, tj, dirr * -1, dirc * -1) + 1;
        } else if (i == n - 1 && j == m - 1 && dirn == 3) {
            return dfs(n, m, i, j, ti, tj, dirr * -1, dirc * -1) + 1;
        } // not full
        else if (i == 0 && dirr == -1) {
            return dfs(n, m, i, j, ti, tj, dirr * -1, dirc) + 1;
        } else if (i == n - 1 && dirr == 1) {
            return dfs(n, m, i, j, ti, tj, dirr * -1, dirc) + 1;
        } else if (j == 0 && dirc == -1) {
            return dfs(n, m, i, j, ti, tj, dirr, dirc * -1) + 1;
        } else if (j == m - 1 && dirc == 1) {
            return dfs(n, m, i, j, ti, tj, dirr, dirc * -1) + 1;
        } else {
            return dfs(n, m, i + dirr, j + dirc, ti, tj, dirr, dirc);
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