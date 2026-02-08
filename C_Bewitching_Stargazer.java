import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Bewitching_Stargazer {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();

            long ans[] = rec(1, n, k);
            System.out.println(ans[0]);
        }
    }

    public static long[] rec(long l, long r, long k) {
        if (r - l + 1 < k)
            return new long[] { 0, 0 };
        if (l == r) {
            return (k <= 1) ? new long[] { l, 1 } : new long[] { 0, 0 };
        }
        long len = r - l + 1;

        long mid = 0;
        if ((len) % 2 == 0) {
            long m = (l + r) / 2;
            long pre[] = rec(l, m, k);
            long preval = pre[0];
            long prepick = pre[1];
            return new long[] { (2L * preval + prepick * m - l + 1), 2 * prepick };
        }

        mid = (l + r) / 2;
        long[] pre = rec(l, mid - 1, k);
        long preval = pre[0];
        long prepick = pre[1];

        return new long[] { (2L * preval + (prepick + 1) * mid), 2 * prepick + 1 };
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