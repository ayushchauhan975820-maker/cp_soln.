import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Sorting_Game {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            int c0 = 0;
            int c1 = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0')
                    c0++;
                else
                    c1++;
            }

            // if alisce cant make a move already fixed
            boolean later = false;
            for (int i = c0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    later = true;
                }
            }

            if (!later || c0 == n || c1 == n) {
                System.out.println("Bob");
                continue;
            }

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (i < c0) {
                    if (s.charAt(i) == '1') {
                        list.add(i + 1);
                    }
                } else {
                    if (s.charAt(i) == '0') {
                        list.add(i + 1);
                    }
                }
            }

            System.out.println("Alice");
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
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