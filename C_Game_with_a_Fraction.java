import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Game_with_a_Fraction {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            long p = fs.nextLong();
            long q = fs.nextLong();
            if (q <= p || p < 2 || q < 3) {
                System.out.println("Alice");
                continue;
            }

            long dif = q - p;
            if (2 * dif <= p) {
                System.out.println("Bob");
            } else {
                System.out.println("Alice");
            }
        }
    }

    /*
     * 3p - 2q = 0
     * a - 2 b
     * so diff b.w no will either inc or stay same if some dif is valid then bob win
     * 
     * x = x + dif
     * 3*x = 2(x + dif)
     * 3*x - 2*x = 2*dif
     * x = 2*dif
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