import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class A_And_Matching {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();

            int mask = n - 1;
            if (n == 4 && k == 3) {
                System.out.println(-1);
                continue;
            }

            if (k == 0) {
                for (int i = 0; i < n / 2; i++) {
                    System.out.println(i + " " + (~i & mask));
                }
            } else if (k == mask) {
                System.out.println((n - 1) + " " + (n - 2));
                System.out.println(1 + " " + (n - 3));
                System.out.println(0 + " " + 2);

                for (int i = 3; i < n / 2; i++) {
                    System.out.println(i + " " + (~i & mask));
                }
            } else {
                System.out.println(k + " " + mask);
                System.out.println(0 + " " + (~k & mask));
                for (int i = 1; i < n / 2; i++) {
                    if (i == k || i == (~k & mask))
                        continue;

                    System.out.println(i + " " + (~i & mask));
                }
            }
        }
    }

    /*
     * so n is power of 2
     * elements 0 to n - 1, every element has its complement
     * 
     * since k < n => k & mask = k
     * ~k & 0 = 0 and everything else 0 so ans k
     * 
     * if k == mask
     * then
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