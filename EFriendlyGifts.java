import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class EFriendlyGifts {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n];
            int mx_val = 0;
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
                mx_val = max(mx_val, a[i]);
            }

            boolean arr[][] = new boolean[mx_val + 1][n + 1];
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<>();
                int mn = 6009;
                int mx = 0;
                for (int j = i; j < n; j++) {
                    int val = a[j];
                    if (set.contains(val))
                        break;
                    mn = min(mn, val);
                    mx = max(mx, val);
                    int ct = j - i + 1;
                    if (mx - mn + 1 == ct) {
                        arr[mx][ct] = true;
                    }
                    set.add(val);
                }
            }

            int mx = 0;
            for (int st = 0; st <= mx_val; st++) {
                for (int len = 1; len <= n; len++) {
                    if (arr[st][len]) {
                        int ed = st + len;
                        if (ed <= mx_val) {
                            if (arr[ed][len])
                                mx = Math.max(mx, len);
                        }
                    }
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