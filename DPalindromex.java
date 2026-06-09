import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class DPalindromex {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[2 * (n + 1)];
            int f = -1;
            int s = -1;
            for (int i = 1; i <= 2 * n; i++) {
                a[i] = fs.nextInt();
                if (a[i] == 0) {
                    if (f == -1)
                        f = i;
                    else
                        s = i;
                }
            }
            HashSet<Integer> set = new HashSet<>();
            int l = f;
            int r = f;
            while (l >= 1 && r <= 2 * n) {
                if (a[l] == a[r]) {
                    set.add(a[l]);
                    l--;
                    r++;
                } else {
                    break;
                }
            }
            int mex = 0;
            while (set.contains(mex))
                mex++;

            set = new HashSet<>();
            l = s;
            r = s;
            while (l >= 1 && r <= 2 * n) {
                if (a[l] == a[r]) {
                    set.add(a[l]);
                    l--;
                    r++;
                } else {
                    break;
                }
            }
            int mex2 = 0;
            while (set.contains(mex2))
                mex2++;

            mex = Math.max(mex, mex2);

            set = new HashSet<>();
            int ml = (s + f) / 2;
            int mr = (s + f + 1) / 2;
            while (ml >= 1 && mr <= 2 * n) {
                if (a[ml] == a[mr]) {
                    set.add(a[ml]);
                    ml--;
                    mr++;
                } else {
                    break;
                }
            }

            mex2 = 0;
            while (set.contains(mex2))
                mex2++;
            mex = Math.max(mex, mex2);

            System.out.println(mex);
        }
    }

    /*
     * only three centers poss 1's 0, 2' 0 and mid b/w 0's
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