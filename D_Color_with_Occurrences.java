import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Color_with_Occurrences {
    static final int mod = (int) 1e9 + 7;
    public static char s[];
    public static HashSet<String> set;
    public static long dp[][];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            String st = fs.next();
            s = st.toCharArray();
            set = new HashSet<>();
            int n = fs.nextInt();
            for (int i = 0; i < n; i++) {
                set.add(fs.next());
            }
            int len = s.length;
            boolean valid[] = new boolean[len];
            for (String str : set) {
                StringBuilder sb = new StringBuilder();
                int l = 0;
                int str_length = str.length();
                for (int i = 0; i < len; i++) {
                    sb.append(s[i]);
                    while (i - l + 1 > str_length) {
                        sb.deleteCharAt(0);
                        l++;
                    }
                    if (str.equals(sb.toString())) {
                        for (int j = l; j <= i; j++) {
                            valid[j] = true;
                        }
                    }
                }
            }

            boolean cor = true;
            for (int i = 0; i < len; i++) {
                if (!valid[i])
                    cor = false;
            }
            if (!cor) {
                System.out.println(-1);
                continue;
            }
            if (set.contains(st)) {
                System.out.println(1 + " " + len);
                continue;
            }

            // dpij is the minimum time to color string i to j

            // assume partition at k (1-k) (k+1 - len)
            long ans = dfs(0, n - 1, len);
            System.out.println(ans);
        }
    }

    public static long dfs(int i, int j, int len) {
        if (i == j) {
            if (set.contains(Character.toString(s[i]))) {
                return 1;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        long ans = Integer.MAX_VALUE;
        String str_nxt = "";
        for (int p = i; p <= j; p++) {
            str_nxt += s[p];
        }

        if (set.contains(str_nxt))
            return 1;

        for (int k = i; k < j - 1; k++) {
            long ff = dfs(i, k, len);
            long sf = dfs(k + 1, j, len);
            ans = min(ans, ff + sf);
        }

        return ans;
    }

    /*
     * partitions can overlap
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