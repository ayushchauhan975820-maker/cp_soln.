import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class B_Meeting_on_the_Line {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int pos[] = new int[n];
            int time[] = new int[n];
            for (int i = 0; i < n; i++)
                pos[i] = fs.nextInt();
            for (int i = 0; i < n; i++)
                time[i] = fs.nextInt();

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                max = max(max, (pos[i] + time[i]));
                min = min(min, (pos[i] - time[i]));
            }

            System.out.println((max + min) / 2.0);
        }
    }

    /*
     * so its like the minimize the maximum time for the last person
     * 
     * so total will always be greater than maximum of time so its optimal to take
     * it close to the max
     * 
     * let say they will meet at time t
     * in t time the can move xi - (t - ti) to xi + (t - ti)
     * now we have to make sure that these ranges intersert for a valid xo
     * max of(xi - (t - ti)) and min of (xi + (t - ti)
     * simplifing t will cancel out
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