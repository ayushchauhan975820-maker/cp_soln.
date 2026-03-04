import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Simons_and_Beating_Peaks {
    static final int mod = (int) 1e9 + 7;
    public static int n;
    public static int a[], left[], right[];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            a = new int[n + 2];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
            }

            left = new int[n + 1];
            right = new int[n + 1];
            Stack<Integer> st = new Stack<>();

            for (int i = 1; i <= n; i++) {
                int lp = 0;
                while (!st.isEmpty() && a[st.peek()] < a[i]) {
                    lp = st.pop();
                }
                left[i] = lp;
                if (!st.isEmpty()) {
                    right[st.peek()] = i;
                }
                st.push(i);
            }
            while (st.size() > 1)
                st.pop();
            int root = st.pop();

            int depth = dfs(root);
            System.out.println(n - depth);
        }
    }

    public static int dfs(int idx) {
        int depth = 0;
        if (left[idx] != 0) {
            depth = max(depth, dfs(left[idx]));
        }
        if (right[idx] != 0) {
            depth = max(depth, dfs(right[idx]));
        }
        return depth + 1;
    }

    /*
     * so in the end we want no peaks in the array
     * function is monotonic
     * 
     * if there is a peak we can either remove the left element of the peak or the
     * right one
     * 
     * can never remove the highest element in the array so only two cases left
     * 
     * in the end the highest element will be at the left or right or both
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