import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Eat_the_Chip {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int h = fs.nextInt();
            int w = fs.nextInt();
            int xa = fs.nextInt();
            int ya = fs.nextInt();
            int xb = fs.nextInt();
            int yb = fs.nextInt();

            if (xb <= xa) {
                System.out.println("Draw");
                continue;
            }

            int hor_dist = Math.abs(xb - xa);
            int crs_bob = hor_dist / 2;
            if (hor_dist % 2 == 1) {
                // alice is in win state bob try to force draw
                long last_ya_left = Math.max(1, -crs_bob + ya - 1);
                long last_yb_left = Math.max(1, -crs_bob + yb);
                long last_ya_right = Math.min(w, crs_bob + ya + 1);
                long last_yb_right = Math.min(w, crs_bob + yb);
                if (last_ya_left > last_yb_left || last_ya_right < last_yb_right) {
                    System.out.println("Draw");
                } else {
                    System.out.println("Alice");
                }
            } else {
                long last_ya_left = Math.max(1, -crs_bob + ya);
                long last_yb_left = Math.max(1, -crs_bob + yb);
                long last_ya_right = Math.min(w, crs_bob + ya);
                long last_yb_right = Math.min(w, crs_bob + yb);
                if (last_ya_left < last_yb_left || last_ya_right > last_yb_right) {
                    System.out.println("Draw");
                } else {
                    System.out.println("Bob");
                }
            }
        }
    }

    /*
     * xa ya xb yb
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