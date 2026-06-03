import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class CSnowfall {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            StringBuilder ans = new StringBuilder();
            StringBuilder rest = new StringBuilder();
            StringBuilder twos = new StringBuilder();
            StringBuilder threes = new StringBuilder();
            int a[] = new int[n + 1];
            for (int i = 1; i <= n; i++)
                a[i] = fs.nextInt();

            for (int i = 1; i <= n; i++) {
                if (a[i] % 6 == 0)
                    ans.append(a[i] + " ");
                else if (a[i] % 2 == 0)
                    twos.append(a[i] + " ");
                else if (a[i] % 3 == 0)
                    threes.append(a[i] + " ");
                else
                    rest.append(a[i] + " ");
            }

            ans.append(twos);
            ans.append(rest);
            ans.append(threes);
            System.out.println(ans.toString());
        }
    }

    /*
     * reorder elements to maximize f(a)
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