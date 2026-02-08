import static java.lang.Math.*;
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class C_Restricted_Sorting {
    static final int mod = (int) 1e9 + 7;
    public static int[] d;
    public static int m;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = new int[n];

            long mn = Long.MAX_VALUE;
            long mx = Long.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
                mn = Math.min(mn, a[i]);
                mx = Math.max(mx, a[i]);
            }
            boolean sorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1]) {
                    sorted = false;
                    break;
                }
            }

            if (sorted) {
                System.out.println("-1");
                continue;
            }

            int[] b = a.clone();
            Arrays.sort(b);

            long l = 1, r = (int) (1e9);
            long ans = 1;

            while (l <= r) {
                long mid = l + (r - l) / 2;
                if (ok(mid, a, b, mn, mx)) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            System.out.println(ans);
        }
    }

    public static boolean ok(long k, int[] a, int[] b, long mn, long mx) {
        long u = mx - k;
        long v = mn + k;

        if (u < v) {
            for (int i = 0; i < a.length; i++) {

                if (a[i] > u && a[i] < v) {

                    if (a[i] != b[i]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int[] uniq(int[] arr) {
        if (arr.length == 0)
            return arr;
        int c = 1;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] != arr[i - 1])
                c++;
        int[] res = new int[c];
        res[0] = arr[0];
        int idx = 1;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] != arr[i - 1])
                res[idx++] = arr[i];
        return res;
    }

    public static void add(int[] b, int i, int v) {
        for (; i < b.length; i += i & -i)
            b[i] += v;
    }

    public static int sum(int[] b, int i) {
        int s = 0;
        for (; i > 0; i -= i & -i)
            s += b[i];
        return s;
    }

    public static int lb(int[] arr, long v) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= v)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static int ub(int[] arr, int v) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > v)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

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