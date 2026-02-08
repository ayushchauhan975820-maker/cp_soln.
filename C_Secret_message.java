import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Secret_message {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            ArrayList<Integer> div = new ArrayList<>();
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    div.add(i);
                    if (n / i != i) {
                        div.add(n / i);
                    }
                }
            }
            String a[] = new String[k];
            for (int i = 0; i < k; i++) {
                a[i] = fs.next();
            }
            Collections.sort(div);
            int col_msk[] = new int[n];
            for (int i = 0; i < n; i++) {
                int val = 0;
                for (int j = 0; j < k; j++) {
                    int ch = a[j].charAt(i) - 'a';
                    val |= (1 << ch);
                }
                col_msk[i] = val;
            }

            for (int frq : div) {
                boolean valid = true;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < frq; i++) {
                    int mask = (1 << 30) - 1;
                    for (int j = i; j < n; j += frq) {
                        mask &= col_msk[j];
                        if (mask == 0) {
                            valid = false;
                            break;
                        }
                    }
                    if (mask != 0) {
                        for (int bit = 0; bit < 30; bit++) {
                            if ((mask & (1 << bit)) != 0) {
                                sb.append((char) (bit + 'a'));
                                break;
                            }
                        }
                    } else
                        break;
                }
                if (valid) {
                    StringBuilder ans = new StringBuilder();
                    for (int i = 0; i < n / frq; i++) {
                        ans.append(sb);
                    }
                    System.out.println(ans);
                    break;
                }
            }
        }
    }

    /*
     * x z
     * y x
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