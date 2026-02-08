import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class A_Adrenaline_Rush {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int f[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = fs.nextInt();
        }
        ArrayList<int[]> list = new ArrayList<>();
        int a[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                list.add(new int[] { a[j], a[j - 1] });
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }

        for (int i = 1; i <= n; i++) {
            int tc = f[i];
            int pos = 0;
            for (int j = i; j <= n; j++) {
                if (a[j] == tc) {
                    pos = j;
                    break;
                }
            }

            for (int j = pos; j > i; j--) {
                list.add(new int[] { a[j], a[j - 1] });
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }

        int len = list.size();
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
        }

    }

    /*
     * 1 2 3
     * 2 3 1
     * 
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