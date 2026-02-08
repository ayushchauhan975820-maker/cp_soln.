import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_OutOfMemoryError {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int h = fs.nextInt();
            int a[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
            }

            Stack<int[]> stack = new Stack<>();
            for (int i = 0; i < m; i++) {
                int idx = fs.nextInt();
                int val = fs.nextInt();
                long ch_val = a[idx] + (long) val;
                if (ch_val > h) {
                    while (!stack.isEmpty()) {
                        int[] rev = stack.pop();
                        int pre_idx = rev[0];
                        int pre_val = rev[1];
                        a[pre_idx] -= pre_val;
                    }
                } else {
                    a[idx] = a[idx] + val;
                    stack.push(new int[] { idx, val });
                }
            }
            for (int i = 1; i <= n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
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