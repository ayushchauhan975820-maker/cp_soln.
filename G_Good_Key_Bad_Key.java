import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class G_Good_Key_Bad_Key {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            long pre[] = new long[n];
            pre[0] = a[0] - k;
            for (int i = 1; i < n; i++) {
                pre[i] = pre[i - 1] + a[i] - k;
            }
            long ans = pre[n - 1];
            // let i be the idx i will use my key on
            for (int i = 0; i < n; i++) {
                long cost = 0;
                for (int j = 1; j < 31 && i + j - 1 < n; j++) {
                    cost += a[i + j - 1] / (1 << (j));
                }
                long prev = (i == 0) ? 0 : pre[i - 1];
                ans = max(ans, cost + prev);
            }
            System.out.println(ans);
        }
    }

    /*
     * the first time we decided to use bad key after that it is always better to
     * use bad key
     * 
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