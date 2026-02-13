import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Decreasing_String {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String s = fs.next();
            long k = fs.nextLong();
            int n = s.length();
            int del = 0;
            while (k > n) {
                k -= n;
                n--;
                del++;
            }
            n = s.length();
            // find the kth element after deleting del elements
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                while (!st.isEmpty() && st.peek() > ch && del > 0) {
                    st.pop();
                    del--;
                }
                st.push(ch);
            }
            while (!st.isEmpty() && del > 0) {
                st.pop();
                del--;
            }

            sb.append(st.get((int) k - 1));
        }
        System.out.println(sb);
    }

    /*
     * check how many characters we need to remove
     * and then in the final string find the character
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