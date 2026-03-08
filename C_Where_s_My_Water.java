import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Where_s_My_Water {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int h = fs.nextInt();
            long rev[] = new long[n + 2];
            for (int i = 1; i <= n; i++) {
                int hgt = fs.nextInt();
                rev[i] = h - hgt;
            }
            rev[0] = Long.MAX_VALUE;
            rev[n + 1] = Long.MAX_VALUE;
            Stack<Integer> st = new Stack<>();
            long prefix[] = new long[n + 2];
            long suffix[] = new long[n + 2];
            for (int i = 1; i <= n; i++) {
                while (!st.isEmpty() && rev[st.peek()] > rev[i]) {
                    st.pop();
                }
                int prev = st.isEmpty() ? 0 : st.peek();
                prefix[i] = prefix[prev] + (long) (i - prev) * rev[i];
                st.push(i);
            }
            st.clear();
            for (int i = n; i >= 1; i--) {
                while (!st.isEmpty() && rev[st.peek()] > rev[i]) {
                    st.pop();
                }
                int next = st.isEmpty() ? n + 1 : st.peek();
                suffix[i] = suffix[next] + (long) (next - i) * rev[i];
                st.push(i);
            }

            long[] prefMax = new long[n + 2];
            for (int i = 1; i <= n; i++) {
                long minH = rev[i];
                long water = prefix[i] - rev[i];
                for (int k = i; k <= n; k++) {
                    minH = Math.min(minH, rev[k]);
                    water += minH;
                    prefMax[k] = Math.max(prefMax[k], water);
                }
            }

            for (int k = 1; k <= n; k++) {
                prefMax[k] = Math.max(prefMax[k], prefMax[k - 1]);
            }

            long[] suffMax = new long[n + 2];
            for (int i = n; i >= 1; i--) {
                long minH = rev[i];
                long water = suffix[i] - rev[i];
                for (int k = i; k >= 1; k--) {
                    minH = Math.min(minH, rev[k]);
                    water += minH;
                    suffMax[k] = Math.max(suffMax[k], water);
                }
            }
            for (int k = n; k >= 1; k--) {
                suffMax[k] = Math.max(suffMax[k], suffMax[k + 1]);
            }

            long min = prefMax[n];
            for (int k = 1; k < n; k++) {
                min = Math.max(min, prefMax[k] + suffMax[k + 1]);
            }

            System.out.println(min);
        }
    }

    /*
     * allowed to place atmost two drains
     * can be same segment or different
     * 
     * can find all the pairs in a segment
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