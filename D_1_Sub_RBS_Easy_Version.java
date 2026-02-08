import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_1_Sub_RBS_Easy_Version {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();

            int[] suffixClose = new int[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                suffixClose[i] = suffixClose[i + 1] + (s.charAt(i) == ')' ? 1 : 0);
            }

            int ans = -1;
            int bal = 0;
            int matchedPrefix = 0;

            for (int i = 0; i < n - 1; i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    bal++;
                } else {
                    bal--;
                }

                if (bal < 0)
                    break;

                matchedPrefix = (i + 1) - bal;

                if (c == ')' && s.charAt(i + 1) == '(') {

                    int debt = bal + 2;
                    int avail = suffixClose[i + 2];

                    if (avail >= debt) {
                        int candidate = ((i + 1) - bal) + 2 * avail - 2;
                        ans = Math.max(ans, candidate);
                    }
                }
            }

            System.out.println(ans);
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