import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class B_Seats {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            int oc = 0;
            int zc = 0;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0')
                    zc++;
                else
                    oc++;
            }

            if (oc == 0) {
                System.out.println((n + 2) / 3);
                continue;
            }

            int l = 0;
            int r = n - 1;
            while (s.charAt(l) == '0') {
                l++;
            }
            while (s.charAt(r) == '0') {
                r--;
            }

            long sum = oc;
            sum += ((l + 1) / 3);
            sum += ((n - r) / 3);

            ArrayList<Integer> block = new ArrayList<>();
            int sz = 0;
            for (int i = l; i <= r; i++) {
                if (s.charAt(i) == '0') {
                    sz++;
                } else {
                    if (sz != 0)
                        block.add(sz);
                    sz = 0;
                }
            }

            for (int i = 0; i < block.size(); i++) {
                sum += (block.get(i)) / 3;
            }

            System.out.println(sum);
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