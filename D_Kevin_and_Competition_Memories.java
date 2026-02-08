import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Kevin_and_Competition_Memories {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();

            long a[] = new long[n + 1];
            a[0] = Long.MAX_VALUE;
            long b[] = new long[m + 1];
            long max_b = 0;
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
                max_b = max(max_b, a[i]);
            }
            long kev_rat = a[1];
            ArrayList<Long> good = new ArrayList<>();
            good.add(0L);
            ArrayList<Long> bad = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                b[i] = fs.nextLong();
            }
            for (int i = 1; i <= m; i++) {
                if (b[i] <= kev_rat || b[i] > max_b) {
                    good.add(b[i]);
                } else {
                    bad.add(b[i]);
                }
            }
            Collections.sort(bad, Comparator.reverseOrder());

            Arrays.sort(a);
            for (int i = 0; i < a.length / 2; i++) {
                long tmp = a[i];
                a[i] = a[a.length - 1 - i];
                a[a.length - 1 - i] = tmp;
            }
            HashMap<Long, Integer> map = new HashMap<>();
            for (long dif : bad) {
                good.add(dif);
                if (map.containsKey(dif))
                    continue;
                int l = 1;
                int r = n;
                int ans = 0;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (a[mid] >= dif) {
                        ans = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                map.put(dif, ans);
            }

            long cost[] = new long[m + 1];
            for (int i = 1; i <= m; i++) {
                long dif = good.get(i);

                if (map.containsKey(dif)) {
                    cost[i] = map.get(dif);
                }
            }

            for (int k = 1; k <= m; k++) {
                //
                long sum = 0;
                for (int end = k; end <= m; end += k) {
                    long val = good.get(end);
                    if (val > kev_rat && val <= max_b) {
                        sum += cost[end];
                    }
                }
                System.out.print(sum + (long) m / k + " ");
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