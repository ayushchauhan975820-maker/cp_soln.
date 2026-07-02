import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class DBerserkMonsters {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long a[] = new long[n + 1];
            long d[] = new long[n + 1];
            for (int i = 1; i <= n; i++)
                a[i] = fs.nextLong();
            for (int i = 1; i <= n; i++)
                d[i] = fs.nextLong();

            int left[] = new int[n + 1];
            int right[] = new int[n + 1];
            for (int i = 2; i <= n; i++)
                left[i] = i - 1;
            for (int i = 1; i < n; i++)
                right[i] = i + 1;

            ArrayList<Integer> del = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                long tot = 0;
                if (i > 1)
                    tot += a[i - 1];
                if (i < n)
                    tot += a[i + 1];

                if (tot > d[i]) {
                    del.add(i);
                }
            }

            for (int i = 1; i <= n; i++) {
                if (del.size() == 0) {
                    System.out.print(0 + " ");
                    continue;
                }
                int sz = del.size();
                System.out.print(sz + " ");
                Collections.sort(del);
                HashSet<Integer> affected = new HashSet<>();
                int l = -1;
                int r = -1;
                for (int j = 0; j < sz; j++) {
                    int idx = del.get(j);
                    if (l == -1) {
                        l = idx;
                        r = idx;
                    } else {
                        if (right[r] == idx) {
                            r = idx;
                        } else {
                            int nl = left[l];
                            int nr = right[r];
                            left[nr] = nl;
                            right[nl] = nr;
                            if (nl != 0)
                                affected.add(nl);
                            if (nr != 0)
                                affected.add(nr);
                            l = idx;
                            r = idx;
                        }
                    }
                }
                int nl = left[l];
                int nr = right[r];
                left[nr] = nl;
                right[nl] = nr;
                if (nl != 0)
                    affected.add(nl);
                if (nr != 0)
                    affected.add(nr);
                // up
                ArrayList<Integer> next_del = new ArrayList<>();
                for (int idx : affected) {
                    int lft = left[idx];
                    int rht = right[idx];
                    long dmg = 0;
                    if (lft != 0)
                        dmg += a[lft];
                    if (rht != 0)
                        dmg += a[rht];
                    if (d[idx] < dmg)
                        next_del.add(idx);
                }
                del = next_del;
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