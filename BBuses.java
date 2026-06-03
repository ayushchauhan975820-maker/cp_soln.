import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class BBuses {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = 1;
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            long l = fs.nextLong();
            long x = fs.nextLong();
            long y = fs.nextLong();
            long st[] = new long[n + 1];
            long ed[] = new long[n + 1];
            long per[] = new long[m + 1];
            Long val[] = new Long[n + 1];
            boolean inval[] = new boolean[n + 1];
            double ans[] = new double[m + 1];
            int sz = 2 * n + m;
            long[][] ln = new long[sz][3];
            int idx = 0;
            PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

            for (int i = 1; i <= n; i++) {
                st[i] = fs.nextLong();
                ed[i] = fs.nextLong();

                ln[idx++] = new long[] { 1, st[i], i };
                ln[idx++] = new long[] { 0, ed[i], i };

                val[i] = (ed[i] - st[i]) * y + (l - ed[i]) * x;
            }

            for (int i = 1; i <= m; i++) {
                per[i] = fs.nextLong();
                ln[idx++] = new long[] { 2, per[i], i };
            }

            Arrays.sort(ln, (a, b) -> {
                if (a[1] == b[1])
                    return Long.compare(a[0], b[0]);
                return Long.compare(a[1], b[1]);
            });

            for (int i = 0; i < sz; i++) {
                long type = ln[i][0];
                long pos = ln[i][1];
                int index = (int) ln[i][2];

                if (type == 1) {
                    pq.add(new long[] { val[index], index });
                } else if (type == 0) {
                    inval[index] = true;
                } else {
                    double mn = (l - pos) / (double) y;
                    while (!pq.isEmpty() && inval[(int) pq.peek()[1]])
                        pq.poll();
                    if (!pq.isEmpty()) {
                        mn = min(mn, pq.peek()[0] / (double) (x * y));
                    }

                    ans[index] = mn;
                }
            }

            for (int i = 1; i <= m; i++) {
                System.out.println(ans[i]);
            }
        }
    }

    /*
    
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