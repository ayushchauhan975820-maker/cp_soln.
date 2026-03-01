import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class B_ABAB_Construction {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            char s[] = fs.next().toCharArray();
            boolean pos = true;
            int ac = 0;
            int bc = 0;
            if (n % 2 != 0) {
                for (int i = 0; i < n; i++) {
                    if (s[i] == 'a')
                        ac++;
                    else if (s[i] == 'b')
                        bc++;
                }
                if (s[0] == 'b') {
                    pos = false;
                } else {
                    for (int i = 1; i < n - 1; i += 2) {
                        if (s[i] != '?' && s[i + 1] != '?' && s[i] == s[i + 1]) {
                            pos = false;
                            break;
                        }
                    }
                }

                if (ac > (n / 2) + 1 || bc > n / 2)
                    pos = false;
            } else {
                for (int i = 0; i < n; i++) {
                    if (s[i] == 'a')
                        ac++;
                    else if (s[i] == 'b')
                        bc++;
                }
                for (int i = 0; i < n - 1; i += 2) {
                    if (s[i] != '?' && s[i + 1] != '?' && s[i] == s[i + 1]) {
                        pos = false;
                        break;
                    }
                }
                if (ac > (n / 2) || bc > n / 2)
                    pos = false;
            }

            if (pos) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    /*
     * t is a string where its a in odd and b in even
     * then s if formed
     * 
     * you are given t find if a s exist for it
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