import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Skibidus_and_Rizz {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int k = fs.nextInt();
            StringBuilder sb = new StringBuilder();
            if (abs(n - m) > k || (n < k && m < k)) {
                System.out.println(-1);
                continue;
            }
            int len = n + m;
            boolean zero_more = n > m;
            for (int i = 0; i < len; i++) {
                if (i < k) {
                    if (zero_more) {
                        sb.append(0);
                        n--;
                    } else {
                        sb.append(1);
                        m--;
                    }
                } else {
                    if (sb.charAt(sb.length() - 1) == '0') {
                        if (m > 0) {
                            sb.append(1);
                            m--;
                        } else {
                            sb.append(0);
                            n--;
                        }
                    } else {
                        if (n > 0) {
                            sb.append(0);
                            n--;
                        } else {
                            sb.append(1);
                            m--;
                        }
                    }
                }
            }

            System.out.println(sb.toString());
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