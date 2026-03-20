import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class B_Cyclists {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int p = fs.nextInt();
            int m = fs.nextInt();

            int a[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
            }

            int el_top = 0;
            if (p > k) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for (int i = 1; i < p; i++) {
                    pq.offer(a[i]);
                }
                for (int i = 0; i < p - k; i++) {
                    el_top += pq.poll();
                }
            }

            if (m < el_top + a[p]) {
                System.out.println(0);
                continue;
            }

            int count = 1;
            m -= (el_top + a[p]);

            int cc = a[p];
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 1; i <= n; i++) {
                if (i != p) {
                    pq.offer(a[i]);
                }
            }

            for (int i = 0; i < n - k; i++) {
                cc += pq.poll();
            }

            count += m / cc;
            System.out.println(count);
        }
    }

    /*
     * move p to last and then pick n - k elements for cycle
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