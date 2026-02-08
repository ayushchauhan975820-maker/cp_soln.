import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_From_1_to_Infinity {
    static final int mod = (int) 1e9 + 7;
    public static ArrayList<Long> list = new ArrayList<>();
    public static long k;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        list.add(0L);
        long n = 9;
        for (int i = 0; i <= 15; i++) {
            list.add(n);
            n *= 10;
            n += 9;
        }
        int t = fs.nextInt();
        while (t-- > 0) {
            k = fs.nextLong();
            long l = 1;
            long r = (long) (1e14);
            long last = 0;
            long rem = 0;
            long sum = 0;
            while (l <= r) {
                long mid = l + (r - l) / 2;
                long ch_k = check_num(mid);

                if (ch_k <= k) {
                    rem = k - ch_k;
                    last = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            String s = Long.toString(last + 1);
            for (int i = 0; i < rem; i++) {
                sum += (s.charAt(i) - '0');
            }

            // sum all the digits from 1 to last
            sum += sum_upto_digit(last);

            System.out.println(sum);
        }
    }

    public static long sum_upto_digit(long n) {
        if (n <= 0)
            return 0L;
        long tot = 0;
        long tot_nums = n + 1;

        for (long p = 1; p <= n; p *= 10) {
            long fb = tot_nums / (p * 10);
            long rem = tot_nums % (p * 10);

            tot += 45 * fb * p;
            long cur_digit = rem / p;
            long mod = rem % p;

            if (cur_digit > 0) {
                tot += ((cur_digit * (cur_digit - 1)) / 2) * p;
            }

            tot += cur_digit * mod;
        }

        return tot;
    }

    public static long check_num(long num) {
        // return k for this number
        long k = 0;
        int idx = 1;
        for (int i = 1; i <= 15; i++) {
            if (list.get(i) > num)
                break;
            k = k + (i * (list.get(i) - list.get(i - 1)));
            idx++;
        }

        long rem = num - list.get(idx - 1);
        k = k + idx * rem;

        return k;
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