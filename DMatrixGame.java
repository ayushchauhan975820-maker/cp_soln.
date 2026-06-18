import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class DMatrixGame {
    static final int mod = (int) 1e9 + 7;
    public static int sz = (int) 1e5 + 10;
    public static long fact[] = new long[sz];

    public static void calc() {
        fact[0] = 1;
        for (int i = 1; i < sz; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }
    }

    public static long ncr(int n, int r) {
        long num = 1;
        for (int i = 0; i < r; i++) {
            long term = n - i;
            num = (num * term) % mod;
        }
        long den = fact[r];

        return (num * modPow(den)) % mod;
    }

    public static long modPow(long num) {
        int pow = mod - 2;
        long res = 1;
        while (pow > 0) {
            if ((pow & 1) == 1)
                res = (res * num) % mod;

            num = (num * num) % mod;
            pow >>= 1;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        calc();
        int t = fs.nextInt();
        while (t-- > 0) {
            long a = fs.nextLong();
            long b = fs.nextLong();
            long k = fs.nextLong();

            long n = (((k * (a - 1)) % mod) + 1) % mod;
            long m = (((k * ncr((int) n, (int) a) % mod) * (b - 1)) % mod + 1) % mod;

            System.out.println(n + " " + m);
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