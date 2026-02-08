import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Two_Colors {
    static final int mod = (int) 1e9 + 7;
    public static int a[];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = fs.nextInt();
            }
            Arrays.sort(a);
            long ans = 0;
            for (int f = 1; f <= n - 1; f++) {
                int s = n - f;
                int totf = bs(f);
                int tots = bs(s);
                int pb = bs(Math.max(s, f));
                if (totf == -1 || tots == -1)
                    continue;

                int inf = m - totf;
                int ins = m - tots;
                long both = (pb == -1 ? 0 : m - pb);
                ans += (long) inf * ins - both;
            }

            System.out.println(ans);
        }
    }

    public static int bs(int clr) {
        int ans = -1;
        int l = 0;
        int r = a.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (clr > a[mid]) {
                l = mid + 1;
            } else {
                ans = mid;
                r = mid - 1;
            }
        }

        return ans;
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