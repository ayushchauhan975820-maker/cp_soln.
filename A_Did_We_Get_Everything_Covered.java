import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class A_Did_We_Get_Everything_Covered {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int m = fs.nextInt();
            String s = fs.next();

            boolean[] seen = new boolean[k];
            int distinct = 0;
            int blocks = 0;
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < m; i++) {
                int c = s.charAt(i) - 'a';
                if (!seen[c]) {
                    seen[c] = true;
                    distinct++;
                }
                if (distinct == k) {
                    ans.append(s.charAt(i));
                    blocks++;
                    Arrays.fill(seen, false);
                    distinct = 0;
                }
            }

            if (blocks >= n) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
                int idx = 0;
                while (ans.length() < n && idx < k) {
                    if (!seen[idx]) {
                        ans.append((char) ('a' + idx));
                    }
                    idx++;
                }

                // fill remaining
                while (ans.length() < n)
                    ans.append('a');

                System.out.println(ans.toString());
            }
        }
    }
    /*
     * abcabcabc
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