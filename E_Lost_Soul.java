import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Lost_Soul {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            HashMap<Integer, Integer> top = new HashMap<>();
            HashMap<Integer, Integer> btm = new HashMap<>();
            int a[] = new int[n];
            int b[] = new int[n];

            int ans = 0;
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = fs.nextInt();
                if (a[i] == b[i]) {
                    ans = Math.max(ans, i + 1);
                }
            }
            if ((n - 1) % 2 == 0) {
                top.put(a[n - 1], n - 1);
                btm.put(b[n - 1], n - 1);
            } else {
                top.put(b[n - 1], n - 1);
                btm.put(a[n - 1], n - 1);
            }
            for (int i = n - 2; i >= 0; i--) {
                int ai = a[i];
                int bi = b[i];
                if (i % 2 == 0) {
                    // if even our element top el can be converted into anything from
                    if (top.containsKey(bi) || btm.containsKey(ai) ||
                            (top.containsKey(ai) && top.get(ai) > i + 1)
                            || (btm.containsKey(bi) && btm.get(bi) > i + 1)) {
                        ans = Math.max(ans, i + 1);
                        break;
                    }

                    if (!top.containsKey(ai)) {
                        top.put(ai, i);
                    }
                    if (!btm.containsKey(b[i])) {
                        btm.put(bi, i);
                    }
                } else {
                    if (btm.containsKey(bi) || top.containsKey(ai) ||
                            (btm.containsKey(ai) && btm.get(ai) > i + 1)
                            || (top.containsKey(bi) && top.get(bi) > i + 1)) {
                        ans = Math.max(ans, i + 1);
                        break;
                    }

                    if (!btm.containsKey(ai)) {
                        btm.put(ai, i);
                    }
                    if (!top.containsKey(b[i])) {
                        top.put(bi, i);
                    }
                }
            }

            System.out.println(ans);
        }
    }

    /*
     * if we already found some ai == bi then we can make all later elements equal
     * so need to find the first index where there exist some x which is in y or
     * some y which is in x
     * 
     * 2 1 5 4 6 4
     * 3 2 4 5 4 6
     * 
     * if(odd idx then top in odd)
     * 
     * so we have even and odd
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