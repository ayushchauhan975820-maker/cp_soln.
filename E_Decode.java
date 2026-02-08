import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Decode {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            String s = fs.next();
            int n = s.length();
            int pfx[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                pfx[i] = pfx[i - 1];
                if (s.charAt(i - 1) == '1') {
                    pfx[i]++;
                } else {
                    pfx[i]--;
                }
            }

            HashMap<Integer, Long> map = new HashMap<>();
            long ans = 0;
            map.put(0, 1L);
            for (int i = 1; i <= n; i++) {
                int val = pfx[i];
                if (map.containsKey(val)) {
                    ans = (ans + (map.get(val) * (long) (n - i + 1))) % mod;
                }

                map.put(val, map.getOrDefault(val, 0L) + i + 1);
            }

            System.out.println(ans);
        }
    }

    /*
     * in brute force i have to check all even substring ending at
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