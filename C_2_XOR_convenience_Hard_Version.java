import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_2_XOR_convenience_Hard_Version {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();

            int p[] = new int[n + 1];
            p[n] = 1;

            for (int i = 2; i < n; i++) {
                p[i] = i ^ 1;
            }

            if (n % 2 != 0) {
                p[1] = n - 1;

                for (int i = 1; i <= n; i++) {
                    System.out.print(p[i] + " ");
                }
                System.out.println();
                continue;
            }

            if ((n & (n - 1)) == 0) {
                System.out.println(-1);
                continue;
            }

            p[1] = n;
            int dig = n - (1 << (31 - Integer.numberOfLeadingZeros(n)));
            int temp = p[1];
            p[1] = p[dig];
            p[dig] = temp;
            for (int i = 1; i <= n; i++) {
                System.out.print(p[i] + " ");
            }
            System.out.println();
        }
    }

    /*
     * 1 2 3 4 5 6
     * 2 3 6 5 4 1
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