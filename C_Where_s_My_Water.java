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
            int pre[] = new int[n + 2];
            int nxt[] = new int[n + 2];
            for (int i = 1; i <= n; i++) {
                while (!st.isEmpty() && rev[st.peek()] > rev[i]) {
                    st.pop();
                }
                pre[i] = st.isEmpty() ? 0 : st.peek();
                st.push(i);
            }
            st.clear();
            for (int i = n; i >= 1; i--) {
                while (!st.isEmpty() && rev[st.peek()] > rev[i]) {
                    st.pop();
                }
                nxt[i] = st.isEmpty() ? n + 1 : st.peek();
                st.push(i);
            }

            long prefix[] = new long[n + 2];
            prefix[1] = rev[1];
            for (int i = 2; i <= n; i++) {
                int prev = pre[i];
                prefix[i] = prefix[prev] + (long) (i - prev) * rev[i];
            }

            long suffix[] = new long[n + 2];
            suffix[n] = rev[n];
            for (int i = n - 1; i >= 1; i--) {
                int next = nxt[i];
                suffix[i] = suffix[next] + (long) (next - i) * rev[i];
            }

            long min = 0;
            for (int i = 1; i <= n; i++) {
                long area_cur = prefix[i] + suffix[i] - rev[i];
                min = max(min, area_cur);
                int M = i;
                for (int j = i + 1; j <= n; j++) {
                    if (rev[j] < rev[M]) {
                        M = j;
                    }
                    long area_second = prefix[j] + suffix[j] - rev[j];
                    // remove common from i and j
                    long area_shared = prefix[M] + suffix[M] - rev[M];

                    long area = area_cur + area_second - area_shared;
                    min = max(min, area);
                }
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