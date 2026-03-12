import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class B_Burglar_and_Matches {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = 1;
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int tot = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
            for (int i = 0; i < m; i++) {
                int ai = fs.nextInt();
                int bi = fs.nextInt();
                pq.offer(new int[] { ai, bi });
            }

            while (!pq.isEmpty()) {
                int a[] = pq.poll();
                if (n == 0)
                    continue;

                if (n >= a[0]) {
                    n -= a[0];
                    tot += a[0] * a[1];
                } else {
                    tot += n * a[1];
                    n = 0;
                }
            }

            System.out.println(tot);
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