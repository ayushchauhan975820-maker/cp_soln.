import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class CVesselsHeightsAndTwoVersionsEasyVersion {
    static final int mod = (int) 1e9 + 7;
    public static long inf = (long) (1e18);

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long h[] = new long[n];
            for (int i = 0; i < n; i++)
                h[i] = fs.nextLong();
            long ans[] = new long[n];

            for (int i = 0; i < n; i++) {
                int f = (i + 1) % n;
                int s = (i - 1 + n) % n;
                long arr[] = new long[n];
                Arrays.fill(arr, inf);
                arr[i] = 0;
                for (int j = 0; j < n - 1; j++) {
                    int pid = (f + n - 1) % n;
                    int nid = (s + 1) % n;
                    long prev = arr[pid];
                    long ph = h[pid];
                    long next = arr[nid];
                    long nh = h[s];
                    arr[f] = min(arr[f], max(prev, ph));
                    arr[s] = min(arr[s], max(next, nh));
                    f = (f + 1) % n;
                    s = (s - 1 + n) % n;
                }

                long sum = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j)
                        sum += arr[j];
                }
                ans[i] = sum;
            }

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
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