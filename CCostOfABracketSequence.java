import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class CCostOfABracketSequence {
    static final int mod = (int) 1e9 + 7;
    public static char a[];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            a = fs.next().toCharArray();
            int best = -1;
            int mn = calc(0, 0);
            int arr[] = new int[n];
            for (int i = 0; i <= k; i++) {
                int op_del = i;
                int cl_del = k - i;
                int find = calc(op_del, cl_del);
                if (find < mn) {
                    mn = find;
                    best = i;
                }
            }

            if (best != -1) {
                int op_del = best;
                int cl_del = k - best;
                int l = 0;
                int r = n - 1;
                int ct_op = 0;
                int ct_cl = 0;
                while (l < n && ct_op < op_del) {
                    if (a[l] == '(') {
                        ct_op++;
                        arr[l] = 1;
                    }
                    l++;
                }
                while (r >= 0 && ct_cl < cl_del) {
                    if (a[r] == ')') {
                        ct_cl++;
                        arr[r] = 1;
                    }
                    r--;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++)
                sb.append(arr[i]);
            System.out.println(sb.toString());
        }
    }

    public static int calc(int op_del, int cl_del) {
        int n = a.length;
        int op = 0;
        int cl = 0;
        int len = 0;
        int l = 0;
        int r = n - 1;
        int ct_op = 0;
        int ct_cl = 0;
        while (l < n && ct_op < op_del) {
            if (a[l] == '(')
                ct_op++;
            l++;
        }
        while (r >= 0 && ct_cl < cl_del) {
            if (a[r] == ')')
                ct_cl++;
            r--;
        }
        if (l > r)
            return 0;
        for (int i = l; i <= r; i++) {
            if (a[i] == '(') {
                op++;
            } else {
                cl++;
            }
            boolean can_m = (op > 0 && cl > 0);
            if (can_m) {
                len += 2;
                op--;
                cl--;
            } else if (cl > 0) {
                cl = 0;
            }
        }

        return len;
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