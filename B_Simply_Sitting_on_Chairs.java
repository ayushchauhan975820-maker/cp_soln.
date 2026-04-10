import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class B_Simply_Sitting_on_Chairs {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n + 1];
            int ct_l[] = new int[n + 1];
            int ct_g[] = new int[n + 1];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
                if (a[i] <= i) {
                    ct_l[i] = ct_l[i - 1] + 1;
                } else {
                    ct_l[i] = ct_l[i - 1];
                }
            }
            // elements greater than i in left
            for (int i = 1; i <= n; i++) {
                pq.offer(a[i]);
                while (!pq.isEmpty() && pq.peek() <= i)
                    pq.poll();
                ct_g[i] = pq.size();
            }
            int ans = ct_l[n];
            int vis[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if (vis[i] == 1)
                    ans = Math.max(ans, ct_l[i - 1] + ct_g[i - 1]);

                vis[a[i]] = 1;
            }

            System.out.println(ans);
        }
    }

    /*
     * move from 1 to i
     * if the ith chair is mark stop
     * else mark the pith chair or skip
     * 
     * i = 2 -> pi = 3 it is better to skip why we would prefer to mark only chairs
     * that are pi <= i
     * 
     * if pi = x
     * then can collect all the chairs b/w 1 to pi that pi <= i or whose pi > i
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