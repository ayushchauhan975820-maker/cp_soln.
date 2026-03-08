import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class B_One_Night_At_Freddy_s {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            long l = fs.nextLong();

            long a[] = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextLong();
            }

            long[] d = new long[m];
            long prev = 0;

            for (int i = 1; i <= n + 1; i++) {
                long end = (i <= n) ? a[i] : l;
                long L = end - prev;
                long F = (i <= n) ? (n - i + 1) : 0;
                int K = (int) min((long) m, F + 1);

                if (L > 0) {
                    long tot = L;

                    for (int j = K - 1; j >= 1; j--) {
                        long cnt = K - j;
                        long diff = d[j - 1] - d[j];

                        if (diff > 0) {
                            if (tot >= diff * cnt) {
                                tot -= diff * cnt;
                                for (int x = j; x < K; x++) {
                                    d[x] = d[j - 1];
                                }
                            } else {
                                long add = tot / cnt;
                                long rem = tot % cnt;
                                for (int x = j; x < K; x++)
                                    d[x] += add;
                                for (int x = j; x < j + rem; x++)
                                    d[x]++;
                                tot = 0;
                                break;
                            }
                        }
                    }

                    if (tot > 0) {
                        long add = tot / K;
                        long rem = tot % K;
                        for (int x = 0; x < K; x++)
                            d[x] += add;
                        for (int x = 0; x < rem; x++)
                            d[x]++;
                    }
                }
                if (i <= n) {
                    for (int x = 0; x < m - 1; x++) {
                        d[x] = d[x + 1];
                    }
                    d[m - 1] = 0;
                }

                prev = end;
            }
            System.out.println(d[0]);
        }
    }

    /*
     * so we can decrease some di to 0 every ai
     * 
     * a b c d e f
     * 1 2 3 4
     * 
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