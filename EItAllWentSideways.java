import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class EItAllWentSideways {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n + 1];
            int max = 0;
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
                max = Math.max(max, a[i]);
            }
            int ct[] = new int[max + 1];
            int pref[] = new int[max + 1];
            pref[0] = n + 1;
            int min_marked = max + 1;

            for (int i = n; i >= 1; i--) {
                int val = a[i];
                ct[val]++;
                for (int j = val + 1; j < min_marked; j++) {
                    pref[j] = i;
                }
                min_marked = Math.min(min_marked, val + 1);
            }
            for (int i = max - 1; i >= 0; i--) {
                ct[i] += ct[i + 1];
            }
            long max_added = 0;

            for (int i = 1; i <= n; i++) {
                int val = a[i];

                int nw_added = i - pref[val] - 1;
                if (nw_added > max_added) {
                    max_added = nw_added;
                }
            }

            long ans = 0;
            for (int i = 1; i <= max; i++) {
                int val = ct[i] - max(0, (n - pref[i]));
                ans += (long) val;
            }

            System.out.println(ans + max_added);
        }
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
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