import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class BAiFindsNothingHere {
    static final long mod = 998244353;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            long n = fs.nextInt();
            long m = fs.nextLong();
            long r = fs.nextLong();
            long c = fs.nextLong();

            long tot = n * m;
            long sub_tot = (n - r + 1) * (m - c + 1);
            long dif = tot - sub_tot;
            long ans = binexp(dif);
            System.out.println(ans);
        }
    }

    public static long binexp(long val) {
        long pow = 2;
        long res = 1;
        while (val > 0) {
            if ((val & 1) != 0)
                res = (res * pow) % mod;
            val >>= 1;
            pow = (pow * pow) % mod;
        }
        return res;
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