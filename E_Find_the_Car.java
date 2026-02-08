import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Find_the_Car {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int q = fs.nextInt();
            int a[] = new int[k + 1];
            int b[] = new int[k + 1];
            for (int i = 1; i <= k; i++) {
                a[i] = fs.nextInt();
            }
            for (int i = 1; i <= k; i++) {
                b[i] = fs.nextInt();
            }
            int dis[] = new int[k];
            int time[] = new int[k];
            for (int i = 0; i < k; i++) {
                dis[i] = a[i + 1] - a[i];
                time[i] = b[i + 1] - b[i];
            }

            for (int i = 0; i < q; i++) {
                int d = fs.nextInt();
                if (d == n) {
                    System.out.print(b[k] + " ");
                    continue;
                }
                int lst = bs(k, d, a);
                // total time till last and then rest
                long tm = b[lst];
                tm += ((long) (d - a[lst]) * (long) time[lst]) / (long) dis[lst];

                System.out.print(tm + " ");
            }
            System.out.println();
        }
    }

    public static int bs(int k, int d, int a[]) {
        int l = 0;
        int r = k - 1;
        int ans = k;
        // first idx such that d greater than or equal to stop
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] <= d) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    /*
     * speed in this interval
     * 
     * for a dist d time is
     * total t for last stop + (d - dis till last stop)/speed in that interval
     * 
     * find the first valid stop such that d is greate or equal that that
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