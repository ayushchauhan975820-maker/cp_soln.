import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Min_Max_MEX {
    static final int mod = (int) 1e9 + 7;
    public static int n;
    public static int k;
    public static int a[];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            k = fs.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }

            int ans = 0;
            int l = 1;
            int r = n / k;

            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (pos(mid)) {
                    l = mid + 1;
                    ans = mid;
                } else {
                    r = mid - 1;
                }
            }

            System.out.println(ans);
        }
    }

    public static boolean pos(int mex) {
        int blocks = 0;
        boolean ch[] = new boolean[mex];
        int dist = 0;
        for (int i = 0; i < n; i++) {
            int val = a[i];
            if (val < mex && !ch[val]) {
                dist++;
                ch[val] = true;
            }
            if (dist == mex) {
                blocks++;
                dist = 0;
                Arrays.fill(ch, false);
            }
        }

        if (blocks >= k)
            return true;

        return false;
    }

    /*
     * can min max will the the max that didn't appear k times
     * 
     * so for
     * x
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