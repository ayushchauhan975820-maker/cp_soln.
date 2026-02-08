import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class F_Expected_Median {
    static final int mod = (int) 1e9 + 7;
    public static long fact[];
    public static int len = (int) 2e5 + 5;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        fact = new long[len + 1];
        fact[0] = 1;
        for (int i = 1; i <= len; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int c0 = 0;
            int c1 = 0;
            for (int i = 0; i < n; i++) {
                int val = fs.nextInt();
                if (val == 0)
                    c0++;
                else
                    c1++;
            }

            // combination
            long tot = 0;
            for (int i = Math.min(c1, k); i >= 0; i--) {
                int need_zero = k - i;
                if (need_zero > i || need_zero > c0)
                    break;

                long choose_one = ncr(c1, i);
                long choose_zeros = ncr(c0, need_zero);
                long val = (choose_one * choose_zeros) % mod;
                tot = (tot + val) % mod;
            }

            System.out.println(tot);
        }
    }

    public static long ncr(int n, int r) {
        if (r < 0 || r > n)
            return 0;
        long num = fact[n];
        long den = (fact[n - r] * fact[r]) % mod;
        return (num * modInverse(den)) % mod;
    }

    public static long power(long base, long exp) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp % 2) == 1)
                res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }

    public static long modInverse(long num) {
        return power(num, mod - 2);
    }

    /*
     * check all subsequences ending at this
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