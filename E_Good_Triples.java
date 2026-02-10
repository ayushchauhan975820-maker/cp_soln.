import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Good_Triples {
    static final int mod = (int) 1e9 + 7;
    public static int a[] = new int[10];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        a[0] = 1;
        for (int i = 2; i <= 10; i++) {
            a[i - 1] = a[i - 2] + i;
        }
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            if (n == 0) {
                System.out.println(1);
                continue;
            }
            long ans = 1;
            while (n > 0) {
                int dig = n % 10;
                n /= 10;
                ans *= (long) (a[dig]);
            }
            System.out.println(ans);
        }
    }

    /*
     * for digsum no carryovers are allowed
     * precompute all the valid combinations for a place
     * 0 000
     * 1 100 010 001
     * 2 2 11
     * 3 111 21
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