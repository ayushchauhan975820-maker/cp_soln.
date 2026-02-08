import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Physical_Education_Lesson {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int x = fs.nextInt();

            int up_slope = n - (x);
            int down_slope = n + (x - 2);
            // no such that (up_slope || down_slope)%(2k - 2) == 0
            HashSet<Integer> set = new HashSet<>();
            fill(set, up_slope, x);
            fill(set, down_slope, x);

            System.out.println(set.size());
        }
    }

    public static void fill(HashSet<Integer> set, int fnl, int x) {
        if (fnl % 2 != 0)
            return;
        fnl = fnl / 2;
        for (int k = 1; k * k <= fnl; k++) {
            if (fnl % k == 0) {
                int rest = fnl / k;
                if (k + 1 >= x) {
                    set.add(k);
                }
                if (rest != k) {
                    if (rest + 1 >= x) {
                        set.add(rest);
                    }
                }
            }
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