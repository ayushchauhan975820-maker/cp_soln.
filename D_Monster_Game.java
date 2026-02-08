import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Monster_Game {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long a[] = new long[n];
            long b[] = new long[n];
            HashMap<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }
            for (int i = 0; i < n; i++) {
                b[i] = fs.nextLong();
            }
            long pre[] = new long[n];
            pre[0] = b[0];
            for (int i = 1; i < n; i++) {
                pre[i] = pre[i - 1] + b[i];
            }
            ArrayList<Long> list = new ArrayList<>();
            for (long key : map.keySet()) {
                list.add(key);
            }
            Collections.sort(list);

            int len = list.size();
            long suf[] = new long[len];
            suf[len - 1] = map.get(list.get(len - 1));
            for (int i = len - 2; i >= 0; i--) {
                suf[i] = suf[i + 1] + map.get(list.get(i));
            }
            long max = 0;
            for (int i = 0; i < len; i++) {
                // available swords for this diff
                long dif = list.get(i);
                long ct = suf[i];

                int lvl = -1;
                int l = 0;
                int r = n - 1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (ct >= pre[mid]) {
                        l = mid + 1;
                        lvl = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                lvl += 1;

                max = Math.max(max, (long) lvl * dif);
            }

            System.out.println(max);
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