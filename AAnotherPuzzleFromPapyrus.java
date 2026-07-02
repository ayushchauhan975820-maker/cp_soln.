import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class AAnotherPuzzleFromPapyrus {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long c = fs.nextLong();
            long a[] = new long[n];
            long b[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
            }
            for (int i = 0; i < n; i++) {
                b[i] = fs.nextLong();
            }

            long cost = Integer.MAX_VALUE;
            boolean reag_req = false;
            for (int i = 0; i < n; i++) {
                if (a[i] < b[i])
                    reag_req = true;
            }

            if (!reag_req) {
                long cst = 0;
                for (int i = 0; i < n; i++) {
                    cst += a[i] - b[i];
                }
                cost = min(cst, cost);
            }

            Arrays.sort(a);
            Arrays.sort(b);
            boolean pos = true;
            for (int i = 0; i < n; i++) {
                if (a[i] < b[i])
                    pos = false;
            }

            if (!pos) {
                System.out.println(-1);
                continue;
            }
            long srt = c;
            for (int i = 0; i < n; i++) {
                srt += a[i] - b[i];
            }
            cost = min(cost, srt);
            System.out.println(cost);
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