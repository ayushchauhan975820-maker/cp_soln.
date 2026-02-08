import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Flower_Boy {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int a[] = new int[n];
            int b[] = new int[m];

            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            for (int i = 0; i < m; i++) {
                b[i] = fs.nextInt();
            }

            // making positons for pref and suff
            int pre[] = new int[m];
            int suf[] = new int[m];
            int j = 0;
            for (int i = 0; i < m; i++) {
                while (j < n && b[i] > a[j])
                    j++;
                pre[i] = j++;
            }
            j = n - 1;
            for (int i = m - 1; i >= 0; i--) {
                while (j >= 0 && b[i] > a[j])
                    j--;
                suf[i] = j--;
            }

            int ans = (int) (1e9 + 2);
            for (int i = 0; i < m; i++) {
                // if deleting current idx ranges must not overlap
                int mp = (i == 0) ? -1 : pre[i - 1];
                int mn = (i == m - 1) ? n : suf[i + 1];

                if (mp < mn) {
                    ans = min(ans, b[i]);
                }
            }

            if (pre[m - 1] < n) {
                System.out.println(0);
                continue;
            }

            if (ans == (int) (1e9 + 2)) {
                System.out.println(-1);
            } else {
                System.out.println(ans);
            }
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