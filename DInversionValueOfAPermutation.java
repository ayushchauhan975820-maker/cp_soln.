import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class DInversionValueOfAPermutation {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long k = fs.nextLong();
            long num = 0;

            long ans = dfs(n - 1, num, 1, k);

            if (ans == -1) {
                System.out.println(0);
            } else {
                int arr[] = new int[n];
                gen(arr, n, ans);
                for (int i = 0; i < n; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static long dfs(int n, long num, int idx, long k) {
        if (k == 0)
            return num;

        if (idx > n)
            return -1;

        if (k < 0)
            return -1;

        // set
        int lst_set = 0;
        for (int i = idx - 1; i >= 0; i--) {
            if ((num & (1L << i)) != 0) {
                lst_set = i;
                break;
            }
        }

        long f = dfs(n, num | (1L << idx), idx + 1, k - ((long) (n - idx + 1) * (idx - lst_set)));
        if (f != -1)
            return f;

        return dfs(n, num, idx + 1, k);
    }

    public static void gen(int a[], int n, long val) {
        int idx = 0;
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        int b[] = new int[n];
        while (idx < n) {
            if ((val & (1 << idx)) != 0) {
                b[idx] = 1;
            }
            idx++;
        }

        int l = -1;
        int r = -1;
        for (int i = 0; i < n; i++) {
            if (b[i] == 0) {
                if (l != -1 && r != -1) {
                    int dif = (r - l + 1) / 2;
                    for (int j = 0; j < dif; j++) {
                        int temp = a[l + j];
                        a[l + j] = a[r - j];
                        a[r - j] = temp;
                    }
                }
                l = i;
                r = -1;
            } else {
                r = i;
            }
        }
        if (l != -1 && r != -1) {
            int dif = (r - l + 1) / 2;
            for (int j = 0; j < dif; j++) {
                int temp = a[l + j];
                a[l + j] = a[r - j];
                a[r - j] = temp;
            }
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