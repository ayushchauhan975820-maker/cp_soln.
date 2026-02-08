import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Best_Price {
    static final int mod = (int) 1e9 + 7;
    public static long a[];
    public static long b[];
    public static int k;
    public static int n;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            k = fs.nextInt();
            a = new long[n];
            b = new long[n];
            PriorityQueue<long[]> pq = new PriorityQueue<>((x, y) -> Long.compare(x[0], y[0]));
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
                pq.offer(new long[] { a[i], 1 });
            }

            for (int i = 0; i < n; i++) {
                b[i] = fs.nextLong();
                pq.offer(new long[] { b[i], 2 });
            }

            long max = 0;
            long people = n;
            long neg = 0;

            while (!pq.isEmpty()) {
                long val = pq.peek()[0];
                long pep_change = 0;
                long neg_change = 0;
                while (!pq.isEmpty() && pq.peek()[0] == val) {
                    long arr[] = pq.poll();
                    long ev_type = arr[1];

                    if (ev_type == 1) {
                        neg_change++;
                    } else {
                        pep_change--;
                        neg_change--;
                    }
                }

                if (neg <= k) {
                    max = Math.max(max, val * people);
                }

                neg += neg_change;
                people += pep_change;
            }

            System.out.println(max);
        }
    }

    /*
     * 1 1 2
     * 2 3 5
     * 
     * k = 3
     * 
     * 
     * (cost) * (no of people)
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