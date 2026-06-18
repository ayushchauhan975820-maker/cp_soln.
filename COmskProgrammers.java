import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class COmskProgrammers {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            long a = fs.nextLong();
            long b = fs.nextLong();
            long x = fs.nextLong();

            ArrayList<long[]> al = new ArrayList<>();
            ArrayList<long[]> bl = new ArrayList<>();
            long op = 0;
            while (a > 0) {
                al.add(new long[] { a, op });
                a /= x;
                op++;
            }
            al.add(new long[] { 0, op });

            op = 0;
            while (b > 0) {
                bl.add(new long[] { b, op });
                b /= x;
                op++;
            }
            bl.add(new long[] { 0, op });

            long mx = Long.MAX_VALUE;
            for (int i = 0; i < al.size(); i++) {
                long vala = al.get(i)[0];
                long cta = al.get(i)[1];
                for (int j = 0; j < bl.size(); j++) {
                    long valb = bl.get(j)[0];
                    long ctb = bl.get(j)[1];

                    mx = min(mx, cta + ctb + abs(valb - vala));
                }
            }

            System.out.println(mx);
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