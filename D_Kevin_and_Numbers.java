import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Kevin_and_Numbers {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            PriorityQueue<Integer> a = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> b = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < n; i++) {
                a.offer(fs.nextInt());
            }
            for (int i = 0; i < m; i++) {
                b.offer(fs.nextInt());
            }

            boolean valid = true;
            while (!b.isEmpty()) {
                if (b.size() > a.size()) {
                    valid = false;
                    break;
                }

                int a_val = a.peek();
                int b_val = b.peek();
                // split nums
                if (a_val > b_val) {
                    valid = false;
                    break;
                }
                if (a_val == b_val) {
                    a.poll();
                    b.poll();
                } else {
                    int val = b.poll();
                    b.offer(val / 2);
                    b.offer((val + 1) / 2);
                }
            }

            if (!valid || a.size() > 0 || b.size() > 0) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }

    }

    /*
     * 
     * if it is in a not in b add
     * if it is in a but freq in a is more than b then add diff
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