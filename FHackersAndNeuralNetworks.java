import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class FHackersAndNeuralNetworks {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            String a[] = new String[n];
            String b[][] = new String[m][n];
            int hrt[] = new int[m];
            boolean exists[] = new boolean[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.next();
            }
            for (int i = 0; i < m; i++) {
                int ct = 0;
                for (int j = 0; j < n; j++) {
                    b[i][j] = fs.next();
                    if (b[i][j].equals(a[j])) {
                        ct++;
                        exists[j] = true;
                    }
                }
                hrt[i] = ct;
            }

            boolean valid = true;
            for (int i = 0; i < n; i++)
                if (!exists[i])
                    valid = false;

            if (!valid) {
                System.out.println(-1);
                continue;
            }

            int mx = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                int hit = hrt[i];
                int rest = n - hit;

                mx = min(mx, n + 2 * rest);
            }

            System.out.println(mx);
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