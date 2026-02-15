import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class B_Heapify_1 {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n + 1];
            boolean pos = true;
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                int idx = i;
                int val = a[i];
                while (idx % 2 == 0 && idx > 0) {
                    idx /= 2;
                }
                while (val % 2 == 0 && val > 0) {
                    val /= 2;
                }

                if (idx != val) {
                    pos = false;
                    break;
                }
            }

            if (pos)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    /*
     * ai with a2i
     * 1 2 4 8 16
     * 3 6 12 18
     * 5 10 20
     * if we div ai by 2 such that it is not 0 and i such that it is not 0
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