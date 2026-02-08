import java.io.*;
import java.util.*;

public class C_Huge_Pile {
    static final int mod = (int) 1e9 + 7;
    public static int inf = (int) (1e9);

    static Map<Integer, Integer> memo = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();

            memo.clear();

            int ans = valid(k, n);

            if (ans >= inf) {
                System.out.println(-1);
            } else {
                System.out.println(ans);
            }
        }
    }

    public static int valid(int k, int n) {
        if (n == k)
            return 0;
        if (n < k)
            return inf;
        if (memo.containsKey(n))
            return memo.get(n);

        int f = valid(k, n / 2);
        int s = valid(k, (n + 1) / 2);

        int res = Math.min(s, f);

        if (res != inf) {
            res += 1;
        }

        memo.put(n, res);
        return res;
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