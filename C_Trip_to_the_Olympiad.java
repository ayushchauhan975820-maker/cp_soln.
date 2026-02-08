import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Trip_to_the_Olympiad {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int l = fs.nextInt();
            int r = fs.nextInt();

            int a = 0;
            int b = 0;
            int c = 0;
            int msb = 0;
            for (int i = 30; i >= 0; i--) {
                if ((l & (1 << i)) != 0 && (r & (1 << i)) != 0) {
                    a |= (1 << i);
                    b |= (1 << i);
                    c |= (1 << i);
                } else if ((l & (1 << i)) != 0 && (r & (1 << i)) == 0) {
                    msb = i;
                    break;
                } else if ((l & (1 << i)) == 0 && (r & (1 << i)) != 0) {
                    msb = i;
                    break;
                }
            }

            a |= (1 << msb);
            b = a - 1;
            for (int i = l; i <= r; i++) {
                if (i != a && i != b) {
                    c = i;
                    break;
                }
            }

            System.out.println(a + " " + b + " " + c);
        }
    }

    /*
     * if valid in all then put in one
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