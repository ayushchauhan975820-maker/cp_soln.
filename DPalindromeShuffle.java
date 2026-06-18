import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class DPalindromeShuffle {
    static final int mod = (int) 1e9 + 7;
    public static char ch[];
    public static boolean pal_st[];
    public static boolean pal_md[];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            ch = fs.next().toCharArray();
            int n = ch.length;
            pal_st = new boolean[n];
            pal_md = new boolean[n];
            for (int i = 0; i < n; i++) {
                boolean sm = (ch[i] == ch[n - i - 1]);
                if (i == 0) {
                    if (sm) {
                        pal_st[i] = true;
                        pal_st[n - i - 1] = true;
                    } else {
                        break;
                    }
                } else {
                    if (sm && pal_st[i - 1]) {
                        pal_st[i] = true;
                        pal_st[n - i - 1] = true;
                    } else {
                        break;
                    }
                }
            }

            for (int i = n / 2 - 1; i >= 0; i--) {
                boolean sm = (ch[i] == ch[n - i - 1]);
                if (i == n / 2 - 1) {
                    if (sm) {
                        pal_md[i] = true;
                        pal_md[n - i - 1] = true;
                    } else {
                        break;
                    }
                } else {
                    if (sm && pal_md[i + 1]) {
                        pal_md[i] = true;
                        pal_md[n - i - 1] = true;
                    } else {
                        break;
                    }
                }
            }

            if (pal_md[0]) {
                System.out.println(0);
                continue;
            }
            int l = 2;
            int r = n - 1;
            int ans = n;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (pos(mid)) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            System.out.println(ans);
        }
    }

    public static boolean pos(int len) {
        int n = ch.length;
        int avl[] = new int[26];
        int need[] = new int[26];
        boolean used_need[] = new boolean[n];
        boolean used_avl[] = new boolean[n];
        int md = (n - 1) / 2 + 1;
        int l = 0;
        for (int r = 0; r < n && l < md; r++) {
            char cr = ch[r];
            char cl = ch[l];

            avl[cr - 'a']++;
            used_avl[r] = true;

            int opp = n - r - 1;
            if (opp > r || opp < l) {
                char op = ch[opp];
                need[op - 'a']++;
                used_need[opp] = true;
            }

            if (used_need[r]) {
                used_need[r] = false;
                need[cr - 'a']--;
            }

            if (r - l + 1 > len) {
                if (used_avl[l]) {
                    avl[cl - 'a']--;
                    used_avl[l] = false;
                }
                int opl = n - l - 1;
                if (used_need[opl]) {
                    used_need[opl] = false;
                    need[ch[opl] - 'a']--;
                } else {
                    need[cl - 'a']++;
                }
                l++;
            }

            if (r - l + 1 == len) {
                int evn = 0;
                int odd = 0;
                boolean has = true;
                for (int i = 0; i <= 25; i++) {
                    if (need[i] > avl[i])
                        has = false;
                    else {
                        int lft = avl[i] - need[i];
                        if (lft % 2 == 0) {
                            evn += lft;
                        } else {
                            odd += lft;
                        }
                    }
                }
                if (r < md) {
                    boolean left = true;
                    boolean mid = has && (evn == 0) && odd == 0;
                    boolean right = true;
                    if (l > 0) {
                        left = pal_st[l - 1];
                    }
                    if (r < md - 1) {
                        right = pal_md[r + 1];
                    }

                    if (left && right && mid)
                        return true;
                } else {
                    boolean left = true;
                    int mn = min(l, n - r - 1);
                    if (mn > 0) {
                        left = pal_st[mn - 1];
                    }
                    boolean right = has;
                    boolean mid = true;
                    int mx = 0;
                    if (n % 2 == 0) {
                        mx = min(md - l, r - md + 1);
                        if (2 * mx != evn || odd != 0) {
                            mid = false;
                        }
                    }
                    if (left && right && mid)
                        return true;
                }
            }
        }

        return false;
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