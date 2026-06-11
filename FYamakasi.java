import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class FYamakasi {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long s = fs.nextLong();
            long x = fs.nextLong();
            long a[] = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextLong();
            }
            long ct = 0;
            HashMap<Long, ArrayList<Integer>> map = new HashMap<>();
            map.put(0L, new ArrayList<>());
            map.get(0L).add(0);
            int lst = 0;
            long sum = 0;

            for (int i = 1; i <= n; i++) {
                if (a[i] > x) {
                    sum = 0;
                    map = new HashMap<>();
                    map.put(0L, new ArrayList<>());
                    map.get(0L).add(i);
                    lst = i;
                } else {
                    sum += a[i];
                    if (a[i] == x)
                        lst = i;
                    if (!map.containsKey(sum))
                        map.put(sum, new ArrayList<>());
                    map.get(sum).add(i);

                    if (map.containsKey(sum - s)) {
                        ArrayList<Integer> ls = map.get(sum - s);
                        int l = 0;
                        int r = ls.size() - 1;
                        int ans = 0;
                        while (l <= r) {
                            int mid = l + (r - l) / 2;
                            int idx = ls.get(mid);

                            if (idx < lst) {
                                ans = mid + 1;
                                l = mid + 1;
                            } else {
                                r = mid - 1;
                            }
                        }

                        ct += ans;
                    }
                }
            }

            System.out.println(ct);
        }
    }

    /*
     * no of subarrays st
     * sum[l .. r] = s
     * max(a[l] .. a[r]) = x
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