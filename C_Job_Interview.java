import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Job_Interview {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int len = n + m + 1;
            int a[] = new int[len];
            int b[] = new int[len];
            long alt[] = new long[len + 1];
            for (int i = 0; i < len; i++) {
                a[i] = fs.nextInt();
            }
            for (int i = 0; i < len; i++) {
                b[i] = fs.nextInt();
            }
            int x = 0;
            int y = 0;
            ArrayList<int[]> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (a[i] > b[i]) {
                    x++;
                    alt[i] = (i == 0) ? a[i] : alt[i - 1] + a[i];
                } else {
                    y++;
                    alt[i] = (i == 0) ? b[i] : alt[i - 1] + b[i];
                }
                list.add(new int[] { x, y });
            }

            long sufa[] = new long[len + 1];
            long sufb[] = new long[len + 1];
            sufa[len - 1] = a[len - 1];
            sufb[len - 1] = b[len - 1];
            for (int i = len - 2; i >= 0; i--) {
                sufa[i] = sufa[i + 1] + a[i];
                sufb[i] = sufb[i + 1] + b[i];
            }
            long ans[] = new long[len];
            for (int i = 0; i < len; i++) {
                int l = 0;
                int r = len - 1;
                int idx = -1;
                boolean al = a[i] > b[i];
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    x = list.get(mid)[0];
                    y = list.get(mid)[1];
                    if (mid >= i) {
                        if (al) {
                            x--;
                        } else {
                            y--;
                        }
                    }
                    if (x <= n && y <= m) {
                        idx = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }

                boolean nz = false;
                if (idx < len - 1) {
                    int ch_sp = list.get(idx + 1)[0];
                    if (idx + 1 >= i && al) {
                        ch_sp--;
                    }
                    if (ch_sp <= n)
                        nz = true;
                    ;
                }

                long sum = 0;
                if (idx != -1) {
                    sum += alt[idx];
                }
                if (idx + 1 < len) {
                    sum += (nz ? sufa[idx + 1] : sufb[idx + 1]);
                }
                if (i <= idx) {
                    sum -= (al ? a[i] : b[i]);
                } else {
                    sum -= (nz ? a[i] : b[i]);
                }
                ans[i] = sum;
            }

            for (int i = 0; i < len; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
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