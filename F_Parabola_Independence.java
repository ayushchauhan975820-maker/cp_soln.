import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class F_Parabola_Independence {
    static final int mod = (int) 1e9 + 7;
    public static boolean ch_ind[][];
    public static int n;
    public static int ct[];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            int eqn[][] = new int[n][3];
            for (int i = 0; i < n; i++) {
                eqn[i][0] = fs.nextInt();
                eqn[i][1] = fs.nextInt();
                eqn[i][2] = fs.nextInt();
            }

            ch_ind = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int a = eqn[i][0] - eqn[i][0];
                    int b = eqn[i][1] - eqn[i][1];
                    int c = eqn[i][2] - eqn[i][2];

                    long d = b * b - 4 * a * c;
                    if (a != 0 && d < 0) {
                        ch_ind[i][j] = true;
                    } else if (a == 0 && b == 0 && c != 0) {
                        ch_ind[i][j] = true;
                    } else {
                        ch_ind[i][j] = false;
                    }
                }
            }

            ct = new int[n];
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (!ch_ind[i][j])
                        count++;
                }
                ct[i] = count;
            }

        }
    }

    public static void ch(int idx) {
        // everytime choose best node for it
        ArrayList<Integer> valid = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ch_ind[idx][i]) {
                valid.add(i);
            }
        }

        //
    }

    /*
     * every parabola will have 2 root
     * 
     * two fun f and g are independent if for a x f(x) != g(x)
     * 
     * a set is organized if all the elements in it is organised pairwise
     * 
     * independent if D < 0
     * independence is not transitive
     * 
     * do a conflict check for every node
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