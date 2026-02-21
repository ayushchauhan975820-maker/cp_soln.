import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Minimize_the_Thickness {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long a[] = new long[n + 1];
            long tot = 0;
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
                tot += a[i];
            }

            long min = Integer.MAX_VALUE;
            long pre = 0;
            for (int i = 0; i < n; i++) {
                pre += a[i];
                // pre sum will be our sum of the segment
                if (tot % pre != 0)
                    continue;
                // check if it is possible to divide
                long max = i + 1;
                int lst = i;
                long sum = 0;
                boolean valid = true;
                for (int j = i + 1; j < n; j++) {
                    sum += a[j];
                    if (sum == pre) {
                        max = Math.max(max, j - lst);
                        lst = j;
                        sum = 0;
                    } else if (sum > pre) {
                        valid = false;
                        break;
                    }
                }

                if (valid && sum == 0) {
                    min = min(min, max);
                }
            }

            System.out.println(min);
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