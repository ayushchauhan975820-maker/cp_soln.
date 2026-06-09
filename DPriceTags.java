import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class DPriceTags {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long y = fs.nextLong();
            int c[] = new int[n];
            int sz = (int) 1e5 + 2;
            int ct[] = new int[sz];
            for (int i = 0; i < n; i++) {
                c[i] = fs.nextInt();
                ct[c[i]]++;
            }
            for (int i = 1; i < sz; i++) {
                ct[i] += ct[i - 1];
            }

        }
    }

    /*
     * so final cost = cost of the items - cost of prize tags
     * C = sum(ci/x) - (miss * y)
     * C = a - b
     * maximize C
     * x >= 2
     * n <= a <= sum(ci/2)
     * 0 <= b <= n * y
     * 
     * r <= ci/x < r + 1
     * rx <= ci < rx + x
     * 
     * r'(x + 1) <= ci < (r' + 1)(x + 1)
     * r'x + r <= ci < r'x + x + r' + 1
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