import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_1_Little_String_Easy_Version {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int c = fs.nextInt();
            String s = fs.next();

            if (s.charAt(0) != '1' || s.charAt(n - 1) != '1') {
                System.out.println(-1);
                continue;
            }

            long tot = 1;
            int ct_one = 0;
            long rem = c;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    ct_one++;
                }
            }

            for (int i = 1; i < ct_one; i++) {
                rem = rem / (gcd(rem, 2));
                tot = (2 * tot) % mod;
            }

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1')
                    continue;
                rem = rem / (gcd(rem, i));
                tot = (tot * (i)) % mod;
            }

            if (rem == 1)
                System.out.println(-1);
            else
                System.out.println(tot);
        }
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
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