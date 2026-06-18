import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class DFullmetalBitchemist {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            char a[] = fs.next().toCharArray();
            int arr[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if (a[i - 1] == '1') {
                    arr[i] = 1;
                } else {
                    arr[i] = 2;
                }
            }
            long dist = 0;
            long rem = 0;
            int alt = 0;
            long ct[] = { 1, 0, 0 };
            int pref = 0;
            for (int i = 1; i <= n; i++) {
                pref = (pref + arr[i]) % 3;

                dist += ct[(pref + 1) % 3] + ct[(pref + 2) % 3];
                ct[pref]++;

                if (i > 1 && arr[i] != arr[i - 1]) {
                    alt++;
                } else {
                    alt = 1;
                }
                rem += (alt - 1) / 2;
            }

            System.out.println(dist - rem);
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