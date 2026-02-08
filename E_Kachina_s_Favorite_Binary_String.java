import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Kachina_s_Favorite_Binary_String {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        Scanner fs = new Scanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();

            StringBuilder sb = new StringBuilder();
            sb.append("! ");
            int lst = n + 1;
            int prev = 0;
            for (int i = 2; i <= n; i++) {
                System.out.println("? " + 1 + " " + i);
                System.out.flush();
                int cur = fs.nextInt();

                if (cur == 0)
                    continue;
                lst = i + 1;
                prev = cur;
                int ones = (i - cur - 1);
                for (int j = 0; j < ones; j++) {
                    sb.append('1');
                }
                for (int j = 0; j < cur; j++) {
                    sb.append('0');
                }
                sb.append('1');
                break;
            }

            for (int i = lst; i <= n; i++) {
                System.out.println("? " + 1 + " " + i);
                System.out.flush();
                int cur = fs.nextInt();

                if (cur == prev) {
                    sb.append('0');
                } else {
                    sb.append('1');
                    prev = cur;
                }
            }

            if (prev == 0) {
                System.out.println("! IMPOSSIBLE");
                System.out.flush();
            } else {
                System.out.println(sb);
                System.out.flush();
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