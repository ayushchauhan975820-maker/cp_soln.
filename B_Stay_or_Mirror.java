import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class B_Stay_or_Mirror {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int p[] = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = fs.nextInt();
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(p[i], i);
            }

            for (int i = n; i >= 1; i--) {
                int stay = i;
                int dob = 2 * n - i;
                int idx = map.get(i);
                int cs = 0;
                int cd = 0;
                for (int j = idx - 1; j >= 0; j--) {
                    if (p[j] > stay)
                        cs++;
                    if (p[j] > dob)
                        cd++;
                }

                for (int j = idx + 1; j < n; j++) {
                    if (p[j] < stay)
                        cs++;
                    if (p[j] < dob)
                        cd++;
                }

                if (cd < cs) {
                    p[idx] = dob;
                }
            }

            // count inv
            long ct = 0;
            for (int i = 0; i < n; i++) {
                int val = p[i];
                for (int j = i + 1; j < n; j++) {
                    if (val > p[j])
                        ct++;
                }
            }

            System.out.println(ct);
        }
    }

    /*
     * 
     * ai can stay pi or increase to 2n - pi
     * all can inc except 5
     * 
     * to avoid inversion all the elements should be in increasing order
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