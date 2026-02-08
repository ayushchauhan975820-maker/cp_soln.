import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Replace_and_Sum {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int q = fs.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];

            int max[] = new int[n + 1];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = fs.nextInt();
            }

            for (int i = n - 1; i >= 0; i--) {
                max[i] = max(max[i + 1], Math.max(a[i], b[i]));
            }

            long pre[] = new long[n];
            pre[0] = max[0];
            for (int i = 1; i < n; i++) {
                pre[i] = pre[i - 1] + (long) max[i];
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < q; i++) {
                int l = fs.nextInt() - 1;
                int r = fs.nextInt() - 1;

                long left = (l == 0) ? 0 : pre[l - 1];

                long sum = pre[r] - left;
                sb.append(sum + " ");
            }

            System.out.println(sb.toString());
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