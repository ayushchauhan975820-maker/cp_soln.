import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class DXorExpressionAndTwoBinaryNumbers {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            long n = fs.nextLong();
            long k = fs.nextLong();

            String s1 = fs.next();
            String s2 = fs.next();

            long a = 0;
            long axb = 0;
            long b = 0;
            for (int i = 0; i < n; i++) {
                boolean as = s1.charAt(i) == '1';
                boolean bs = s2.charAt(i) == '1';
                if (as)
                    a++;
                if (bs)
                    b++;
                if ((as && !bs) || (!as && bs))
                    axb++;
            }
            long unit = a * (n - a) + b * (n - b) + axb * (n - axb);
            long extra = a * (n - a) + b * (n - b);
            long pow = (1L << k) + 1;
            long ans = (pow / 3) * unit + ((k % 2 == 0) ? extra : 0);
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