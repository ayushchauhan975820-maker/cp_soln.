import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class B_Flipping_Binary_String {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            char bin[] = fs.next().toCharArray();
            int ct_zero = 0;
            int ct_one = 0;
            for (char ch : bin) {
                if (ch == '1') {
                    ct_one++;
                } else {
                    ct_zero++;
                }
            }

            if (ct_one % 2 != 0 && ct_zero % 2 == 0) {
                System.out.println(-1);
                continue;
            } else if (ct_one == 0) {
                System.out.println(0);
                continue;
            }

            if (ct_one % 2 == 0) {
                System.out.println(ct_one);
            } else {
                System.out.println(ct_zero);
            }
            for (int i = 0; i < n; i++) {
                if (ct_one % 2 != 0 && bin[i] == '0') {
                    System.out.print(i + 1 + " ");
                }
                if (ct_one % 2 == 0 && bin[i] == '1') {
                    System.out.print(i + 1 + " ");
                }
            }
            System.out.println();
        }
    }

    /*
     * x 1's
     * 111111
     * 
     * 1010
     * 1101
     * 0000
     * 
     * 
     * 
     * 101
     * 110
     * 000
     * 
     * 
     * 000111
     * 011000
     * 110111
     * 000000
     * 
     * 0011
     * 1110
     * 0000
     * 
     * 011
     * 000
     * 
     * 11000
     * 10111
     * 00000
     * 
     * 11100
     * 00001
     * 11111
     * 
     * 101
     * 110
     * 000
     * 
     * 1010
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