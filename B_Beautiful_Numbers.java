import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class B_Beautiful_Numbers {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            long no = fs.nextLong();

            long rest = no;
            ArrayList<Long> list = new ArrayList<>();
            while (rest > 9) {
                list.add(rest % 10);
                rest /= 10;
            }

            Collections.sort(list);
            int left = 0;
            for (int i = 0; i < list.size(); i++) {
                if (rest + list.get(i) >= 10) {
                    left = list.size() - i;
                    break;
                } else {
                    rest += list.get(i);
                }
            }

            int c = 1;
            long f = 1;
            for (int i = 0; i < list.size(); i++) {
                if (f + list.get(i) < 10) {
                    f += list.get(i);
                } else {
                    c++;
                }
            }

            System.out.println(min(left, c));
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