import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class A_Doremy_s_IQ {
    static final int mod = (int) 1e9 + 7;
    public static int n;
    public static int a[];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            int q = fs.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            int l = 1;
            int r = n;
            int max = 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                boolean ch = valid(mid, q);
                if (ch) {
                    max = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            // construct string
            int can_skp = n - max;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (a[i] > q) {
                    if (can_skp > 0) {
                        can_skp--;
                        sb.append(0);
                        continue;
                    } else {
                        if (q > 0) {
                            sb.append(1);
                            q--;
                        } else {
                            sb.append(0);
                        }
                    }
                } else {
                    if (q > 0)
                        sb.append(1);
                    else
                        sb.append(0);
                }
            }

            System.out.println(sb);
        }
    }

    public static boolean valid(int x, int q) {
        // she can test x
        int can_skp = n - x;
        int ct = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > q) {
                if (can_skp > 0) {
                    can_skp--;
                    continue;
                } else {
                    if (q > 0) {
                        ct++;
                        q--;
                    }
                }
            } else {
                if (q > 0) {
                    ct++;
                }
            }
        }

        return ct >= x;
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