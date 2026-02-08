import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class B_Reverse_a_Permutation {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            StringBuilder sb = new StringBuilder();
            int val = n;
            int l = n;
            for (int i = 0; i < n; i++) {
                if (a[i] != val) {
                    l = i;
                    break;
                }
                sb.append(a[i] + " ");
                val--;
            }

            if (l == n) {
                for (int i = 0; i < n; i++) {
                    System.out.print(a[i] + " ");
                }
                System.out.println();
                continue;
            }

            int r = l;
            while (r < n) {
                if (a[r] == val)
                    break;
                r++;
            }

            for (int i = r; i >= l; i--) {
                sb.append(a[i] + " ");
            }

            for (int i = r + 1; i < n; i++) {
                sb.append(a[i] + " ");
            }

            System.out.println(sb.toString());
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