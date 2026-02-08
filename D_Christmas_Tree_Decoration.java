import java.io.*;
import java.util.*;

public class D_Christmas_Tree_Decoration {
    static final long MOD = 998244353L;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int t = fs.nextInt();

        long[] fact = new long[51];
        fact[0] = 1;
        for (int i = 1; i <= 50; i++)
            fact[i] = fact[i - 1] * i % MOD;

        while (t-- > 0) {
            int n = fs.nextInt();
            long[] a = new long[n + 1];
            for (int i = 0; i <= n; i++)
                a[i] = fs.nextLong();

            long a0 = a[0];
            long sum = 0;
            for (int i = 0; i <= n; i++) {
                sum += a[i];
            }
            long box = sum / n;
            long he = sum % n;

            // combine
            int cth = 0;
            for (int i = 1; i <= n; i++) {
                if (a[i] == box + 1)
                    cth++;
                if (a[i] > box + 1) {
                    cth = -1;
                    break;
                }
            }
            if (cth == -1 || cth > he) {
                System.out.println(0);
                continue;
            }

            long waysToPlaceHeavy = (fact[(int) he] * modInverse(fact[(int) he - cth], MOD)) % MOD;
            long waysToPlaceRest = fact[n - cth];

            long ans = (waysToPlaceHeavy * waysToPlaceRest) % MOD;
            System.out.println(ans);
        }
    }

    public static long modInverse(long base, long mod) {
        return power(base, mod - 2, mod);
    }

    static long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1)
                res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

    /*
     * 4 4 3 3
     * 2! 3!
     * 
     */

    static class FastScanner {
        private final byte[] buf = new byte[1 << 16];
        private int idx = 0, size = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        int read() throws IOException {
            if (idx >= size) {
                size = in.read(buf);
                idx = 0;
                if (size <= 0)
                    return -1;
            }
            return buf[idx++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }

            long x = 0;
            while (c > ' ') {
                x = x * 10 + (c - '0');
                c = read();
            }
            return neg ? -x : x;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}