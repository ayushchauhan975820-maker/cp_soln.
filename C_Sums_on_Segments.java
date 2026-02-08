import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Sums_on_Segments {
    static final int mod = (int) 1e9 + 7;
    public static int n;
    public static int a[];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            int idx = -1;
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
                if (a[i] != 1 && a[i] != -1) {
                    idx = i;
                }
            }
            TreeSet<Long> set = new TreeSet<>();
            if (idx == -1) {
                int min = rev_kad(0, n - 1);
                int max = kad(0, n - 1);
                System.out.println(max - min + 1);
                for (int i = min; i <= max; i++) {
                    System.out.print(i + " ");
                }
            } else {
                int min = Math.min(rev_kad(0, idx - 1), rev_kad(idx + 1, n - 1));
                int max = Math.max(kad(0, idx - 1), kad(idx + 1, n - 1));

                for (long i = min; i <= max; i++) {
                    set.add(i);
                }

                // prefix from idx to left and right
                int left_max = 0;
                int right_max = 0;
                int left_min = 0;
                int right_min = 0;
                int sum = 0;
                for (int i = idx - 1; i >= 0; i--) {
                    sum += a[i];
                    left_max = max(left_max, sum);
                    left_min = min(left_min, sum);
                }
                sum = 0;
                for (int i = idx + 1; i < n; i++) {
                    sum += a[i];
                    right_max = max(right_max, sum);
                    right_min = min(right_min, sum);
                }

                long mn = a[idx] + (long) left_min + right_min;
                long mx = a[idx] + (long) left_max + right_max;
                for (long i = mn; i <= mx; i++) {
                    set.add(i);
                }
                System.out.println(set.size());
                for (long val : set) {
                    System.out.print(val + " ");
                }
            }
            System.out.println();
        }
    }

    public static int kad(int l, int r) {
        int sum = 0;
        int max = 0;
        for (int i = l; i <= r; i++) {
            sum += a[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    public static int rev_kad(int l, int r) {
        int sum = 0;
        int min = 0;
        for (int i = l; i <= r; i++) {
            sum += a[i];
            min = Math.min(min, sum);
            if (sum > 0) {
                sum = 0;
            }
        }
        return min;
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