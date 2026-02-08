import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class A_Cards_Partition {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long k = fs.nextLong();
            long max = 0;
            long tot = 0;
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
                max = Math.max(max, a[i]);
                tot += a[i];
            }

            long ans = 0;
            for (int ht = n; ht >= 0; ht--) {
                if (valid(ht, tot, k, max)) {
                    ans = ht;
                    break;
                }
            }

            System.out.println(ans);
        }
    }

    public static boolean valid(long height, long tot, long k, long max) {
        long tot_blocks = tot + k;

        long base_len = tot_blocks / height;
        if (base_len < max)
            return false;

        long rem = tot_blocks % height;
        if (rem > k)
            return false;
        return true;
    }

    /*
     * max will be our base
     * and distrubute k such that i complete the k's and build layers
     * 
     * 
     * check if height of h is possible or not
     * 
     * sum + k/h
     * 
     * tot + k/h
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