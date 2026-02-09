import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Table_Cut {
    static final int mod = (int) 1e9 + 7;
    public static int grid[][];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            grid = new int[n][m];
            int ct = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = fs.nextInt();
                    if (grid[i][j] == 1)
                        ct++;
                }
            }
            int to_col = ct / 2;
            int left = to_col;
            int last_i = 0;
            int last_j = 0;
            StringBuilder ans = new StringBuilder();
            if (to_col == 0) {
                for (int i = 0; i < m; i++) {
                    ans.append('R');
                }
                for (int i = 0; i < n; i++) {
                    ans.append('D');
                }
                System.out.println(0);
                System.out.println(ans);
                continue;
            }
            for (int i = n - 1; i >= 0; i--) {
                boolean broken = false;
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1)
                        to_col--;
                    if (to_col == 0) {
                        broken = true;
                        last_i = i;
                        last_j = j;
                        break;
                    }
                }
                if (broken) {
                    break;
                }
            }
            for (int i = 0; i < last_i; i++) {
                ans.append('D');
            }
            for (int i = 0; i <= last_j; i++) {
                ans.append('R');
            }
            ans.append('D');
            for (int i = last_j + 1; i < m; i++) {
                ans.append('R');
            }
            for (int i = last_i + 1; i < n; i++) {
                ans.append('D');
            }
            System.out.println((long) left * (ct - left));
            System.out.println(ans);
        }
    }

    /*
     * pick as many a we want pick
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