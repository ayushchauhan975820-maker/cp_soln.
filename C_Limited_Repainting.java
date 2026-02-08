import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Limited_Repainting {
    static final int mod = (int) 1e9 + 7;
    public static ArrayList<long[]> list;
    public static int k;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            k = fs.nextInt();
            String s = fs.next();
            int pen[] = new int[n];
            for (int i = 0; i < n; i++) {
                pen[i] = fs.nextInt();
            }

            list = new ArrayList<>();
            // 0 r 1 b
            list.add(new long[] { (s.charAt(0) == 'R' ? 0L : 1L), (long) pen[0] });
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    list.get(list.size() - 1)[1] = Math.max((long) pen[i], list.get(list.size() - 1)[1]);
                } else {
                    list.add(new long[] { (s.charAt(i) == 'R' ? 0L : 1L), (long) pen[i] });
                }
            }

            int len = list.size();
            int bbc = 0;
            for (int i = 0; i < len; i++) {
                if (list.get(i)[0] == 1)
                    bbc++;
            }

            if (bbc <= k) {
                System.out.println(0);
                continue;
            }

            int l = 0;
            int r = (int) 1e9;
            int ans = 0;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                boolean valid = ch(mid);
                if (valid) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            System.out.println(ans);
        }
    }

    public static boolean ch(int pen) {
        // pen is the maximum allowed penalty
        int ct = 0;
        long lst = -1;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[1] <= pen)
                continue;
            if (lst == -1) {
                if (list.get(i)[0] == 0) {
                    lst = 0;
                } else {
                    lst = 1;
                    ct++;
                }
            } else {
                if (list.get(i)[0] != lst) {
                    lst = list.get(i)[0];
                    if (lst == 1)
                        ct++;
                }
            }
        }

        if (ct <= k)
            return true;
        return false;
    }

    /*
     * can do atmost k ops
     * can paint consecutive blocks in one go
     * so penalty would be the maximum of wrong painted cell
     * true -> can avoid this penalty
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