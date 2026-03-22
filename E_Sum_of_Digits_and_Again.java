import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Sum_of_Digits_and_Again {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            String s = fs.next();
            int n = s.length();
            int dig[] = new int[10];
            for (int i = 0; i < n; i++) {
                dig[s.charAt(i) - '0']++;
            }

            // find the max and min length for that
        }
    }

    /*
     * so S(x) -> sum of digits appended till we get x <= 9
     * 
     * S(x) always starts with x then sum of x then sum of sum of x
     * order of digits initially doesnot matter
     * 
     * because ordering of the digits doesnot matter in x for first time can be
     * distribute it
     * 
     * can be find the length of the original?
     * 
     * be can try to build a graph but ordering will matter if you can find the some
     * valid combination
     * which can be like factorial!
     * 
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