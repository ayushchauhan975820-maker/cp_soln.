import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Zero_Sum_Prefixes {
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
            long sum = 0;
            long ct = 0;
            int max = 0;
            HashMap<Long, Integer> map = new HashMap<>();
            boolean valid = false;
            for (int i = 0; i < n; i++) {
                if (a[i] == 0) {
                    if (valid) {
                        // end previous range and start new
                        ct += max;
                    }
                    valid = true;
                    max = 1;
                    sum = 0;
                    map = new HashMap<>();
                    map.put(0L, 1);
                } else {
                    sum += a[i];
                    if (valid) {
                        map.put(sum, map.getOrDefault(sum, 0) + 1);
                        max = Math.max(max, map.get(sum));
                    } else {
                        if (sum == 0) {
                            ct++;
                        }
                    }
                }
            }

            if (valid)
                ct += max;

            System.out.println(ct);
        }
    }

    /*
     * can bs for the max score
     * 
     * we can replace a zero with some value to make some prefix zero
     * 
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