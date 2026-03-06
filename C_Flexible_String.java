import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Flexible_String {
    static final int mod = (int) 1e9 + 7;
    public static String s;
    public static HashSet<Character> set;
    public static long ans;
    public static char a[], b[];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int vis[] = new int[26];
            a = fs.next().toCharArray();
            b = fs.next().toCharArray();
            int ct = 0;
            for (int i = 0; i < n; i++) {
                if (vis[a[i] - 'a'] == 0) {
                    ct++;
                    vis[a[i] - 'a'] = 1;
                }
            }
            int m = min(k, ct);
            s = new String();
            ans = 0;
            set = new HashSet<>();
            for (int i = 0; i < 26; i++) {
                if (vis[i] == 1) {
                    s += (char) (i + 'a');
                }
            }
            bt(0, m);

            System.out.println(ans);
        }
    }

    public static void bt(int idx, int m) {
        if (m == 0) {
            int n = a.length;
            long tot = 0;
            int len = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == b[i] || set.contains(a[i])) {
                    len++;
                } else {
                    tot += ((long) (len + 1) * len) / 2;
                    len = 0;
                }
            }
            tot += ((long) len * (len + 1)) / 2;
            ans = max(ans, tot);
            return;
        }
        if (idx >= s.length())
            return;

        // leave
        bt(idx + 1, m);
        // set
        set.add(s.charAt(idx));
        bt(idx + 1, m - 1);
        set.remove(s.charAt(idx));
    }

    /*
     * so in one ops we change a char in a to match the char in b
     * instead of forming new ranges increasing size of a range increases answer by
     * more
     * set can only contains atmost k ops
     * that means if we change a char to something then we can change any of its
     * occurance
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