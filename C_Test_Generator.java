import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Test_Generator {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            long s = fs.nextLong();
            long m = fs.nextLong();
            int s_lsb = -1;
            int m_lsb = -1;
            for (int i = 0; i <= 62; i++) {
                if (s_lsb == -1 && (s & (1L << i)) != 0) {
                    s_lsb = i;
                }
                if (m_lsb == -1 && (m & (1L << i)) != 0) {
                    m_lsb = i;
                }
            }
            if (s_lsb < m_lsb) {
                System.out.println(-1);
                continue;
            }
            long bit[] = new long[63];
            // 64 * 64
            for (int i = 62; i >= 0; i--) {
                if ((s & (1L << i)) == 0)
                    continue;
                // find closest bit to left
                // fix the double count
                for (int j = i; j >= 0; j--) {
                    if ((m & (1L << j)) != 0) {
                        bit[j] += (1L << (i - j));
                        break;
                    }
                }
            }
            long low = 1;
            long high = s;
            long ans = s;

            while (low <= high) {
                // let length of the array be mid
                long mid = low + (high - low) / 2;
                long carry = 0;
                boolean pos = true;

                for (int i = 62; i >= 0; i--) {
                    long cur = bit[i] + carry;

                    if ((m & (1L << i)) != 0) {
                        if (cur > mid) {
                            carry = (cur - mid) * 2;
                        } else {
                            carry = 0;
                        }
                    } else {
                        carry = cur * 2;
                    }

                    if (carry > (long) 2e18) {
                        pos = false;
                        break;
                    }
                }
                if (carry > 0)
                    pos = false;

                if (pos) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            System.out.println(ans);
        }
    }

    /*
     * s and m given and have to construct an array
     * sum (ai) = s
     * ai & m = ai
     * if such an array exist find its minimum length
     * 
     * so ai can have bit as in m
     * 
     * so we have to get binary representation of s using bits of a
     * if we have two bits at position x then we can add those bits and form the
     * next bit and every bit
     * can only be shiftet left
     * 
     * it there is a set bit in x that doesnot have in y then -1
     * 
     * all the bits that are set in both need only 1 lenght
     * then rest need the 2 ^ closest bit to them in right
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