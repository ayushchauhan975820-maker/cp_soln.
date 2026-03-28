import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_2_Equal_Multisets_Hard_Version {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = fs.nextInt();
            }

            boolean valid = true;
            int[] freq = new int[n + 1];

            for (int i = 0; i < k; i++) {
                freq[a[i]]++;
            }

            for (int c = 0; c < k; c++) {
                boolean is_same = true;
                for (int i = c; i < n; i += k) {
                    if (a[i] != a[c])
                        is_same = false;
                }

                if (!is_same) {
                    for (int i = c; i < n; i += k) {
                        if (b[i] != -1 && b[i] != a[i])
                            valid = false;
                    }
                    freq[a[c]]--;
                    if (freq[a[c]] < 0)
                        valid = false;

                } else {
                    int val_b = -1;
                    for (int i = c; i < n; i += k) {
                        if (b[i] != -1) {
                            if (val_b == -1)
                                val_b = b[i];
                            else if (val_b != b[i])
                                valid = false;
                        }
                    }

                    if (val_b != -1) {
                        freq[val_b]--;
                        if (freq[val_b] < 0)
                            valid = false;
                    }
                }
            }

            if (valid)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    /*
     * elements can be duplicate
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