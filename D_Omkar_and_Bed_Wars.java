import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Omkar_and_Bed_Wars {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            boolean allsame = true;
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    allsame = false;
                }
            }
            if (allsame) {
                System.out.println((n + 2) / 3);
                continue;
            }

            int ans = 0;
            int i = 0;
            int e = n - 1;
            if (s.charAt(0) == s.charAt(n - 1)) {
                int l = 0;
                int r = n - 1;

                while (l < n && s.charAt(l) == s.charAt(0))
                    l++;
                while (r > 0 && s.charAt(r) == s.charAt(n - 1))
                    r--;

                int mrgd = l + (n - 1 - r);
                ans += mrgd / 3;
                i = l;
                e = r;
            }

            while (i <= e) {
                int j = i;
                while (j <= e && s.charAt(j) == s.charAt(i))
                    j++;
                ans += (j - i) / 3;
                i = j;
            }

            System.out.println(ans);
        }
    }

    /*
     * strategy -
     * if attacked by 0 or 2 attack either of them
     * if attacked by 1 attack in response
     * 
     * let say for idx i if attcked by r and l then attck back
     * min no of ops req to make optimal till i if it is attcking towrds j
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