import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Divisibility_Game {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int max = 0;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            int b[] = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = fs.nextInt();
                max = Math.max(max, b[i]);
            }

            // ai < n + m <= (1e6)
            HashMap<Integer, Integer> map = new HashMap<>();
            int dp[] = new int[max + 1];
            for (int i = 0; i < n; i++) {
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }

            for (int val : map.keySet()) {
                int count = map.get(val);
                for (int i = 1; (long) i * val <= max; i++) {
                    dp[i * val] += count;
                }
            }

            int g_alice = 0;
            int g_bob = 0;
            int mid = 0;
            for (int i = 0; i < m; i++) {
                if (dp[b[i]] == 0) {
                    g_bob++;
                } else if (dp[b[i]] == n) {
                    g_alice++;
                } else {
                    mid++;
                }
            }

            if (g_alice + (mid + 1) / 2 > g_bob + mid / 2) {
                System.out.println("Alice");
            } else {
                System.out.println("Bob");
            }
        }
    }

    /*
     * alice choose -> y is divisible by x
     * bob choose -> y is not divisible by x
     * 
     * since x will always in the array
     * alice will win when all x's have some factor in b
     * 
     * y is then removed from the array
     * 
     * we can divide the array in two portions
     * first y that has some divisor in x
     * and then x that doesn't
     * 
     * whoseever is bigger that wins
     * 
     * any no that is like div by all (lcm) is good for alice so bob cant remove
     * those no
     * alice will remove all y's where there is some factor where bob can make x,y
     * pair
     * 
     * all the no that doesn't have any divisors are good for bob
     * 
     * alice will remove len + 1/2 rest bob
     * if (a_good + (len + 1)/2 > (b_good + (len)/2)) then alice win
     * else bob
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