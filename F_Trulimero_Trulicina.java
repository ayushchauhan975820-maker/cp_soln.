import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class F_Trulimero_Trulicina {
    static final int mod = (int) 1e9 + 7;
    public static int n;
    public static int m;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            m = fs.nextInt();
            int k = fs.nextInt();
            int grid[][] = new int[n][m];

            int clr = 0;
            if (m % k != 0) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        grid[i][j] = clr + 1;
                        clr = (clr + 1) % k;
                    }
                }
            } else {
                for (int j = 0; j < m; j++) {
                    grid[0][j] = clr + 1;
                    clr = (clr + 1) % k;
                }
                // cyclic shift for rest
                for (int i = 1; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        int next_idx = (j + 1) % m;
                        grid[i][j] = grid[i - 1][next_idx];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static boolean valid(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < m)
            return true;
        return false;
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