import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Absolute_Cinema {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
            }

            long totalSum = (a[0] + a[n - 1]) / (n - 1);

            long[] fx = new long[n];
            long prev_pfx_sum = 0;

            for (int i = 0; i < n - 1; i++) {

                long diff = a[i + 1] - a[i];
                long cur_pref_sum = (diff + totalSum) / 2;
                fx[i] = cur_pref_sum - prev_pfx_sum;
                prev_pfx_sum = cur_pref_sum;
            }

            fx[n - 1] = totalSum - prev_pfx_sum;

            for (int i = 0; i < n; i++) {
                System.out.print(fx[i] + " ");
            }
            System.out.println();
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