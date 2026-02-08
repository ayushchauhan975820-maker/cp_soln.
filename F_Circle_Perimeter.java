import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class F_Circle_Perimeter {
    static final int mod = (int) 1e9 + 7;
    public static int rad;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            rad = fs.nextInt();
            long tot = 0;
            for (int i = 0; i <= rad; i++) {
                tot += (bs(i, rad + 1) - bs(i, rad));
            }
            System.out.println(tot);
        }
    }

    public static long bs(long x, long rd) {
        long l = 0;
        long r = rd;
        long max = 0;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long rhs = (long) rd * rd - (long) mid * mid;
            if (rhs >= 0 && (long) x * x < rhs) {
                max = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return 4L * max;
    }

    /*
     * x2 <= r^2 - y^2
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