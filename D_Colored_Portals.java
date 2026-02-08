import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Colored_Portals {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int q = fs.nextInt();
            String a[] = new String[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.next();
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            int cls_left[] = new int[n + 1];
            int cls_right[] = new int[n + 1];
            Arrays.fill(cls_left, -1);
            Arrays.fill(cls_right, n + 1);

            for (int i = 1; i <= n; i++) {
                int mask = getInt(a[i]);
                int comb[] = generateComb(mask);
                for (int j = 0; j < 4; j++) {
                    if (map.containsKey(comb[j])) {
                        cls_left[i] = Math.max(cls_left[i], map.get(comb[j]));
                    }
                }
                map.put(mask, i);
            }
            map.clear();
            for (int i = n; i >= 1; i--) {
                int mask = getInt(a[i]);
                int comb[] = generateComb(mask);
                for (int j = 0; j < 4; j++) {
                    if (map.containsKey(comb[j])) {
                        cls_right[i] = Math.min(cls_right[i], map.get(comb[j]));
                    }
                }
                map.put(mask, i);
            }

            while ((q-- > 0)) {
                int x = fs.nextInt();
                int y = fs.nextInt();

                int m1 = getInt(a[x]);
                int m2 = getInt(a[y]);
                if ((m1 & m2) != 0) {
                    System.out.println(abs(x - y));
                } else {
                    int l = cls_left[x];
                    int r = cls_right[x];
                    int min = Integer.MAX_VALUE;
                    if (l != -1) {
                        min = Math.min(min, abs(x - l) + abs(l - y));
                    }

                    if (r != n + 1) {
                        min = Math.min(min, abs(x - r) + abs(r - y));
                    }
                    if (min == Integer.MAX_VALUE) {
                        System.out.println(-1);
                    } else {
                        System.out.println(min);
                    }
                }
            }
        }
    }

    public static int[] generateComb(int mask) {
        int fst[] = new int[2];
        int sec[] = new int[2];
        for (int i = 0; i < 2; i++) {
            fst[i] = -1;
            sec[i] = -1;
        }
        for (int i = 3; i >= 0; i--) {
            if ((mask & (1 << i)) != 0) {
                if (fst[0] == -1) {
                    fst[0] = i;
                } else {
                    fst[1] = i;
                }
            } else {
                if (sec[0] == -1) {
                    sec[0] = i;
                } else {
                    sec[1] = i;
                }
            }
        }
        int idx = 0;
        int arr[] = new int[4];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int val = 0;
                val |= (1 << fst[i]);
                val |= (1 << sec[j]);
                arr[idx++] = val;
            }
        }

        return arr;
    }

    public static int getInt(String s) {
        int val = 0;
        for (int i = 0; i < 2; i++) {
            char ch = s.charAt(i);
            if (ch == 'B') {
                val |= 1;
            } else if (ch == 'G') {
                val |= 2;
            } else if (ch == 'R') {
                val |= 4;
            } else {
                val |= 8;
            }
        }

        return val;
    }

    /*
     * b = 0, g = 1; r = 2; y = 3
     * 
     * if they share any color then its simply abs(i - j)
     * 
     * if they dont then find some xy which x but with z or z with y
     * find some such that or of them is 1
     * 1001
     * 
     * 1100
     * 1010
     * 0101
     * 0011
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