import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Divisive_Battle {
    static final int mod = (int) 1e9 + 7;
    public static int len = (int) (1e6 + 5);
    public static int seive[] = new int[len];

    public static void calc() {
        seive[1] = 1;
        for (int i = 2; i * i < len; i++) {
            if (seive[i] != 0)
                continue;
            seive[i] = i;
            for (int j = i * i; j < len; j += i) {
                seive[j] = i;
            }
        }
        for (int i = 2; i < len; i++) {
            if (seive[i] == 0) {
                seive[i] = i;
            }
        }
    }

    public static int getFact(int num) {
        int first = -1;

        while (num > 1) {
            int p = seive[num];
            if (first == -1) {
                first = p;
            } else if (first != p) {
                return -1;
            }
            while (num % p == 0) {
                num /= p;
            }
        }

        return first;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        calc();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n + 1];
            a[0] = Integer.MIN_VALUE;
            boolean sorted = true;
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
                if (a[i] < a[i - 1])
                    sorted = false;
            }

            if (sorted) {
                System.out.println("Bob");
                continue;
            }
            boolean valid = true;
            for (int i = 1; i <= n; i++) {
                int fact = 1;
                if (a[i] != 1) {
                    fact = getFact(a[i]);
                }
                if (fact == -1 || a[i - 1] > fact) {
                    valid = false;
                    break;
                }
                a[i] = fact;
            }
            if (valid) {
                System.out.println("Bob");
            } else {
                System.out.println("Alice");
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