import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Arcology_On_Permafrost {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int k = fs.nextInt();

            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 1; i <= m + 1; i++) {
                list.add(new ArrayList<>());
            }

            int ct = k * m;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < k; j++) {
                    list.get(i).add(j);
                }
            }

            // add remaining in the last
            int val = 0;
            while (ct < n && list.get(m).size() < k) {
                list.get(m).add(val++);
                ct++;
            }

            // distribute equally
            while (ct < n) {
                for (int i = 0; i <= m; i++) {
                    if (ct < n) {
                        list.get(i).add(val);
                        ct++;
                    }
                }
                val++;
            }

            for (int i = 0; i <= m; i++) {
                for (int j = 0; j < list.get(i).size(); j++) {
                    System.out.print(list.get(i).get(j) + " ");
                }
            }
            System.out.println();
        }
    }

    /*
     * so we have to place every no k unit apart atleast
     * 
     * fill all with atleast k then fill last and
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