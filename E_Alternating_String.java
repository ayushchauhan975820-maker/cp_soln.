import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Alternating_String {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();

            // solve for even
            long ans = Integer.MAX_VALUE;
            if (n % 2 == 0) {
                int evn[] = new int[26];
                int odd[] = new int[26];
                int evnmax = 0;
                int oddmax = 0;
                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0) {
                        evn[s.charAt(i) - 'a']++;
                        evnmax = max(evnmax, evn[s.charAt(i) - 'a']);
                    } else {
                        odd[s.charAt(i) - 'a']++;
                        oddmax = max(oddmax, odd[s.charAt(i) - 'a']);
                    }
                    ans = n - evnmax - oddmax;
                }
            } else {
                int suffe[][] = new int[n][26];
                int suffo[][] = new int[n][26];
                suffe[n - 1][s.charAt(n - 1) - 'a']++;
                for (int i = n - 2; i >= 0; i--) {
                    for (int j = 0; j < 26; j++) {
                        suffo[i][j] = suffo[i + 1][j];
                        suffe[i][j] = suffe[i + 1][j];
                    }
                    if (i % 2 == 0) {
                        suffe[i][s.charAt(i) - 'a']++;
                    } else {
                        suffo[i][s.charAt(i) - 'a']++;
                    }
                }

                int min = n;
                for (int i = 0; i < n; i++) {
                    // lets del this idx
                    for (int j = 0; j < 26; j++) {
                        suffo[i][j] = i - 1 < 0 ? 0 : suffo[i - 1][j];
                        suffe[i][j] = i - 1 < 0 ? 0 : suffe[i - 1][j];
                    }
                    if (i % 2 == 0) {
                        suffe[i][s.charAt(i) - 'a']++;
                    } else {
                        suffo[i][s.charAt(i) - 'a']++;
                    }

                    // find max even and odd from i - 1 and i + 1
                    int maxe = 0;
                    int maxo = 0;
                    for (int j = 0; j < 26; j++) {
                        int oddl = (i - 1 < 0) ? 0 : suffo[i - 1][j];
                        int oddr = (i + 1 >= n) ? 0 : suffo[i + 1][j];
                        int evenl = (i - 1 < 0) ? 0 : suffe[i - 1][j];
                        int evenr = (i + 1 >= n) ? 0 : suffe[i + 1][j];
                        maxe = Math.max(maxe, evenl + oddr);
                        maxo = Math.max(maxo, oddl + evenr);
                    }

                    min = Math.min(min, n - maxe - maxo);
                }
                ans = min;
            }

            System.out.println(ans);
        }
    }

    /*
     * 
     * if all even then no del pos
     * will pick the character that is maximum and change in every other pos
     * same for oddd
     * 
     * 
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