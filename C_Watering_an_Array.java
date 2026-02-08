import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Watering_an_Array {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int d = fs.nextInt();

            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }

            int v[] = new int[k];
            for (int i = 0; i < k; i++) {
                v[i] = fs.nextInt();
            }

            int ct = 0;
            for (int i = 0; i < n; i++) {
                if (i + 1 == a[i])
                    ct++;
            }
            ct += (d - 1) / 2;
            for (int j = 0; j < min(2 * n, d); j++) {
                int val = v[j % k];
                for (int i = 0; i < val; i++) {
                    a[i]++;
                }

                int new_ct = 0;
                for (int i = 0; i < n; i++) {
                    if (i + 1 == a[i])
                        new_ct++;
                }
                int rem_day = (d - (j + 2));
                if (rem_day >= 0) {
                    ct = max(ct, new_ct + rem_day / 2);
                }
            }
            System.out.println(ct);
        }
    }

    /*
     * c = count of all j such that (aj = j)
     * on a day we can add c or increment first bi elements by 1
     * 
     * 000
     * so ai can never be less than ai + 1 after performing second op1 so at max 1
     * or 0
     * last idx where you do 2 after that it is len/2
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