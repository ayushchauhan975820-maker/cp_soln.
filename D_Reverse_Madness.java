import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Reverse_Madness {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            String str = fs.next();
            char s[] = new char[n + 1];
            for (int i = 1; i <= n; i++) {
                s[i] = str.charAt(i - 1);
            }
            int l[] = new int[k + 1];
            int r[] = new int[k + 1];
            for (int i = 1; i <= k; i++) {
                l[i] = fs.nextInt();
            }
            for (int i = 1; i <= k; i++) {
                r[i] = fs.nextInt();
            }
            int q = fs.nextInt();
            int x[] = new int[q + 1];
            for (int i = 1; i <= q; i++) {
                x[i] = fs.nextInt();
            }
            int pre_idx[] = new int[q + 1];
            for (int i = 1; i <= q; i++) {
                int xi = x[i];
                int idx = 0;
                int low = 1;
                int high = k;
                while (low <= high) {
                    int mid = low + (high - low) / 2;

                    if (l[mid] <= xi) {
                        idx = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                pre_idx[i] = idx;
            }
            int dif[] = new int[n + 2];
            for (int i = 1; i <= q; i++) {
                int xi = x[i];
                int idx = pre_idx[i];
                int a = min(xi, l[idx] + r[idx] - xi);
                int b = max(xi, l[idx] + r[idx] - xi);
                dif[a]++;
                dif[b + 1]--;
            }
            for (int i = 1; i <= n; i++) {
                dif[i] += dif[i - 1];
            }
            for (int i = 1; i <= k; i++) {
                int li = l[i];
                int ri = r[i];
                for (int j = 0; j <= (ri - li) / 2; j++) {
                    if (dif[li + j] % 2 == 0)
                        continue;
                    char temp = s[li + j];
                    s[li + j] = s[ri - j];
                    s[ri - j] = temp;
                }
            }
            for (int i = 1; i <= n; i++) {
                System.out.print(s[i]);
            }
            System.out.println();
        }
    }

    /*
     * l < x < r
     * [a,b]
     * dif = r - x;
     * if((l + r)/2 >= x) then its [x, l + dif]
     * else its[l+dif, x]
     * 
     * reverse substring from idx a to b
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