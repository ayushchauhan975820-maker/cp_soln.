import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class H_Honey_Cake {
    static final int mod = (int) 1e9 + 7;
    public static ArrayList<Long> w_div;
    public static ArrayList<Long> h_div;
    public static ArrayList<Long> d_div;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = 1;
        while (t-- > 0) {
            int w = fs.nextInt();
            int h = fs.nextInt();
            int d = fs.nextInt();
            int n = fs.nextInt();
            w_div = new ArrayList<>();
            h_div = new ArrayList<>();
            d_div = new ArrayList<>();
            find_div(w, w_div);
            find_div(h, h_div);
            find_div(d, d_div);
            long vol = (long) w * h * d;
            if (vol % n != 0) {
                System.out.println(-1);
                continue;
            }
            long req = vol / n;
            for (int i = 0; i < w_div.size(); i++) {
                for (int j = 0; j < h_div.size(); j++) {
                    long wdt = w_div.get(i);
                    long hgt = h_div.get(j);
                    long area = 1L * wdt * hgt;

                    if (req % area != 0)
                        continue;

                    long len = req / area;
                    boolean valid = bs(len);

                    if (valid) {
                        System.out.println((w / wdt - 1) + " " + (h / hgt - 1) + " " + (d / len - 1));
                        return;
                    }
                }
            }
            System.out.println(-1);
        }
    }

    public static boolean bs(long x) {
        int l = 0;
        int r = d_div.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (d_div.get(mid) == x) {
                return true;
            } else if (d_div.get(mid) < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }

    public static void find_div(int n, ArrayList<Long> list) {
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                if (n / i != i) {
                    list.add(n / i);
                }
            }
        }
        Collections.sort(list);
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