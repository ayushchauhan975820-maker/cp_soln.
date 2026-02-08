import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class F_Pizza_Delivery {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int ax = fs.nextInt();
            int ay = fs.nextInt();
            int bx = fs.nextInt();
            int by = fs.nextInt();
            int add[][] = new int[n + 1][2];
            for (int i = 0; i < n; i++) {
                add[i][0] = fs.nextInt();
            }
            for (int i = 0; i < n; i++) {
                add[i][1] = fs.nextInt();
            }
            TreeMap<Integer, long[]> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                int x = add[i][0];
                int y = add[i][1];

                if (!map.containsKey(x)) {
                    map.put(x, new long[] { y, y });
                } else {
                    long arr[] = map.get(x);
                    arr[0] = Math.min(arr[0], y);
                    arr[1] = Math.max(arr[1], y);
                }
            }

            long prev_x = ax;
            long prev_y_f = ay;
            long prev_y_s = ay;

            long cost_f = 0;
            long cost_s = 0;

            for (Map.Entry<Integer, long[]> entry : map.entrySet()) {
                long cur_x = entry.getKey();
                long cur_y_f = entry.getValue()[0];
                long cur_y_s = entry.getValue()[1];

                long dist = cur_y_s - cur_y_f;
                long lvl_dist = cur_x - prev_x;

                long f_to_f = cost_f + lvl_dist + dist + Math.abs(prev_y_f - cur_y_s);
                long s_to_f = cost_s + lvl_dist + dist + Math.abs(prev_y_s - cur_y_s);
                long next_cost_f = Math.min(f_to_f, s_to_f);

                long f_to_s = cost_f + lvl_dist + dist + Math.abs(prev_y_f - cur_y_f);
                long s_to_s = cost_s + lvl_dist + dist + Math.abs(prev_y_s - cur_y_f);
                long next_cost_s = Math.min(f_to_s, s_to_s);

                prev_x = cur_x;
                prev_y_f = cur_y_f;
                prev_y_s = cur_y_s;
                cost_f = next_cost_f;
                cost_s = next_cost_s;
            }

            long dist = bx - prev_x;
            long fnl_x_f = cost_f + dist + Math.abs(by - prev_y_f);
            long fnl_x_s = cost_s + dist + Math.abs(by - prev_y_s);

            System.out.println(Math.min(fnl_x_f, fnl_x_s));
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