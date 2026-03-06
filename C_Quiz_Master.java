import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Quiz_Master {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();

            int a[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
            }
            Arrays.sort(a);
            int arr[] = new int[m + 1];
            int ct = 0;
            int max = Integer.MAX_VALUE;
            int l = 1;
            for (int i = 1; i <= n; i++) {
                // add divisors of current no
                for (int j = 1; j * j <= a[i]; j++) {
                    if (a[i] % j == 0) {
                        if (j <= m) {
                            if (arr[j] == 0)
                                ct++;
                            arr[j]++;
                        }

                        if (j != a[i] / j && a[i] / j <= m) {
                            if (arr[a[i] / j] == 0)
                                ct++;
                            arr[a[i] / j]++;
                        }
                    }
                }

                if (ct == m) {
                    // valid subarray
                    max = min(max, a[i] - a[l]);

                    // make it invalid again
                    while (ct == m) {
                        // remove divisors of last no
                        for (int j = 1; j * j <= a[l]; j++) {
                            if (a[l] % j == 0) {
                                if (j <= m) {
                                    if (arr[j] == 1)
                                        ct--;
                                    arr[j]--;
                                }

                                if (j != a[l] / j && a[l] / j <= m) {
                                    if (arr[a[l] / j] == 1)
                                        ct--;
                                    arr[a[l] / j]--;
                                }
                            }
                        }
                        l++;
                        if (ct == m) {
                            max = min(max, a[i] - a[l]);
                        }
                    }
                }
            }

            if (max == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(max);
            }
        }
    }

    /*
     * so we only need to focus on nos 1 to m if for any ai%m there is a smaller one
     * present
     * its better to take that
     * 
     * for what m we are limited
     * 
     * student ai can solve topic mi, if ai%mi == 0
     * minimize the difference b/w highest and lowest choose ai
     * 
     * so the choosen set of ai must have all divisors from 1 to m
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