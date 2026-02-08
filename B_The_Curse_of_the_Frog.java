import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class B_The_Curse_of_the_Frog {
    static final int mod = (int) 1e9 + 7;
    public static long max;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long x = fs.nextLong();
            int[][] arr = new int[n][3];
            max = -1;
            boolean pos = false;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i][0] = fs.nextInt();
                arr[i][1] = fs.nextInt();
                arr[i][2] = fs.nextInt();
                if (((long) arr[i][0] * arr[i][1]) > arr[i][2]) {
                    pos = true;
                }
                sum += (long) (arr[i][1] - 1) * arr[i][0];
                max = Math.max(max, ((long) (arr[i][1]) * arr[i][0]) - arr[i][2]);
            }

            if (!pos) {
                System.out.println(-1);
                continue;
            }

            long l = 0;
            long r = x;
            long ans = -1;
            while (l <= r) {
                long mid = l + (r - l) / 2;

                if (mid >= (x - sum + max - 1) / max) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            System.out.println(ans);
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