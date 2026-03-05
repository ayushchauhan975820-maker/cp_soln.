import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Least_Prefix_Sum {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            long prefix[] = new long[n + 1];
            int a[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
                prefix[i] = prefix[i - 1] + a[i];
            }

            PriorityQueue<Integer> low = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
            PriorityQueue<Integer> high = new PriorityQueue<>();
            long pre_val = prefix[m];
            int l = m;
            int count = 0;
            while (l > 0) {
                if (prefix[l] < pre_val) {
                    // reduce some +ve
                    int val = low.poll();
                    pre_val -= 2L * val;
                    count++;
                }
                low.offer(a[l]);
                l--;
            }
            int r = m + 1;
            long cur_val = pre_val;
            while (r <= n) {
                high.offer(a[r]);
                cur_val += a[r];
                if (cur_val < pre_val) {
                    int val = high.poll();
                    cur_val -= 2L * val;
                    count++;
                }
                r++;
            }
            System.out.println(count);
        }
    }

    /*
     * if we change the value at an index then it is only going to lower or increase
     * all the later elements
     * so it is an invariant for all the later elements wrt m
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