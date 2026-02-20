import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class B_Factorial_Divisibility {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int x = fs.nextInt();
        int ct[] = new int[500002];
        for (int i = 0; i < n; i++) {
            int val = fs.nextInt();
            ct[val]++;
        }

        for (int i = 1; i < n; i++) {
            int count = ct[i];
            int need_to_convert = i + 1;
            ct[i + 1] += count / need_to_convert;
            ct[i] = count % need_to_convert;
        }

        boolean valid = true;
        for (int i = 0; i < x; i++) {
            if (ct[i] != 0) {
                valid = false;
                break;
            }
        }

        if (valid)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    /*
     * a1! + a2! + .... + an! is div by x!
     * means
     * a1! + a2! + .... + an! = kx!
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