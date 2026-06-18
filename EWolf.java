import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class EWolf {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int q = fs.nextInt();
            int p[] = new int[n + 1];
            int pos[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = fs.nextInt();
                pos[p[i]] = i;
            }
            int ans[] = new int[q];
            for (int i = 0; i < q; i++) {
                int l = fs.nextInt();
                int r = fs.nextInt();
                int k = fs.nextInt();
                int idx = pos[k];
                if (idx < l || idx > r) {
                    ans[i] = -1;
                } else {
                    int bg_av = n - k;
                    int sm_av = k - 1;
                    int bg_need = 0;
                    int sm_need = 0;
                    // int ex_sm = 0;
                    // int ex_bg = 0;
                    while (l <= r) {
                        int mid = (l + r) / 2;

                        if (idx == mid)
                            break;
                        else if (idx < mid) {
                            // need big
                            if (p[mid] > k) {
                                bg_av--;
                            } else {
                                bg_need++;
                                // ex_sm++;
                            }
                            r = mid - 1;
                        } else {
                            if (p[mid] < k) {
                                sm_av--;
                            } else {
                                sm_need++;
                                // ex_bg++;
                            }
                            l = mid + 1;
                        }
                    }

                    int com = min(sm_need, bg_need);
                    sm_av -= com;
                    bg_av -= com;
                    sm_need -= com;
                    bg_need -= com;

                    if (sm_av < 0 || bg_av < 0 || sm_need > sm_av || bg_need > bg_av) {
                        ans[i] = -1;
                    } else {
                        ans[i] = 2 * com + 2 * (sm_need + bg_need);
                    }
                }
            }

            for (int i = 0; i < q; i++) {
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