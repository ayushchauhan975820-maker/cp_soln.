import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class A_Breach_of_Faith {
    static final int mod = (int) 1e9 + 7;

    // prove your solution dont code until you prove it

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long a[] = new long[2 * n];
            long sum = 0;
            for (int i = 0; i < 2 * n; i++) {
                a[i] = fs.nextLong();
            }
            Arrays.sort(a);
            long ans[] = new long[2 * n + 1];
            int l = 0;
            int r = 2 * n - 1;
            for (int i = 0; i < 2 * n - 1; i++) {
                if ((i & 1) == 0) {
                    ans[i] = a[r--];
                    sum += ans[i];
                } else {
                    ans[i] = a[l++];
                    sum -= ans[i];
                }
            }
            ans[2 * n] = a[r--];
            sum += ans[2 * n];

            ans[2 * n - 1] = sum;
            for (int i = 0; i <= 2 * n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }

    /*
     * a b c
     * a is first
     * ai is pos
     * 
     * assume to insert on right of a no
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