import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Spring {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            long a = fs.nextLong();
            long b = fs.nextLong();
            long c = fs.nextLong();
            long m = fs.nextLong();

            // they will meet at the lcm days
            long gcd_ab = gcd(a, b);
            long gcd_bc = gcd(b, c);
            long gcd_ca = gcd(c, a);

            long lcm_ab = (a * b) / gcd_ab;
            long lcm_bc = (b * c) / gcd_bc;
            long lcm_ca = (c * a) / gcd_ca;
            long lcm_abc = (lcm_ab / gcd(lcm_ab, c)) * c;

            // water alone - +6 for single , -3 for both, +2 for triple
            long water_a = 6 * (m / a) + (-3) * (m / lcm_ab) + (-3) * (m / lcm_ca) + 2 * (m / lcm_abc);
            long water_b = 6 * (m / b) + (-3) * (m / lcm_ab) + (-3) * (m / lcm_bc) + 2 * (m / lcm_abc);
            long water_c = 6 * (m / c) + (-3) * (m / lcm_bc) + (-3) * (m / lcm_ca) + 2 * (m / lcm_abc);

            System.out.println(water_a + " " + water_b + " " + water_c);
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
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