import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D1InfiniteSequenceEasyVersion {
    static final int mod = (int) 1e9 + 7;
    public static int n;
    public static int a[];
    public static int xor;
    public static int xorx;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            long l = fs.nextLong();
            long r = fs.nextLong();
            a = new int[2 * n + 2];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
            }
            xor = 0;
            for (int i = 1; i <= n; i++) {
                xor ^= a[i];
                if (2 * i > n) {
                    a[2 * i] = xor;
                }
                if (n % 2 == 0 && (n + 1) / 2 == i) {
                    a[n + 1] = xor;
                }
            }

            for (int i = n + 2; i <= 2 * n; i++) {
                if (i % 2 != 0) {
                    a[i] = a[i - 1];
                }
            }
            a[2 * n + 1] = xor;
            xorx = xor ^ a[n + 1];

            int xr = find(l);
            System.out.println(xr);
        }
    }

    public static int find(long val) {
        if (val <= 2 * n + 1) {
            return a[(int) val];
        }

        long half = val / 2;

        if (n % 2 == 0) {
            if (half % 2 == 0) {
                return xorx ^ find(half);
            } else {
                return xorx;
            }
        } else {
            if (half % 2 == 0) {
                return xor ^ find(half);
            } else {
                return xor;
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