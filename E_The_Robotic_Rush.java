import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_The_Robotic_Rush {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int k = fs.nextInt();
            int a[] = new int[n];
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            for (int i = 0; i < m; i++) {
                set.add(fs.nextInt());
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            String s = fs.next();
            int minL = 0;
            int maxR = 0;
            int idx = 0;

            for (int i = 0; i < k; i++) {
                int val = (s.charAt(i) == 'L') ? -1 : 1;
                idx += val;

                if (idx < minL) {
                    minL = idx;
                    if (!map.containsKey(minL)) {
                        map.put(minL, i + 1);
                    }
                }
                if (idx > maxR) {
                    maxR = idx;
                    if (!map.containsKey(maxR)) {
                        map.put(maxR, i + 1);
                    }
                }
            }

            int ans[] = new int[k + 2];

            for (int i = 0; i < n; i++) {
                int pos = a[i];
                Integer right_spike = set.ceiling(pos);
                Integer left_spike = set.floor(pos);

                int time = Integer.MAX_VALUE;

                if (right_spike != null) {
                    int dist = right_spike - pos;
                    if (map.containsKey(dist)) {
                        time = Math.min(time, map.get(dist));
                    }
                }
                if (left_spike != null) {
                    int dist = left_spike - pos;
                    if (map.containsKey(dist)) {
                        time = Math.min(time, map.get(dist));
                    }
                }
                if (time != Integer.MAX_VALUE) {
                    ans[time]++;
                }
            }

            int alive = n;
            for (int i = 1; i <= k; i++) {
                alive -= ans[i];
                System.out.print(alive + " ");
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