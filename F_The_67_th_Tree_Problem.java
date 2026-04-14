import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class F_The_67_th_Tree_Problem {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int x = fs.nextInt();
            int y = fs.nextInt();
            boolean valid = true;
            ArrayList<int[]> list = new ArrayList<>();

            if (x > y)
                valid = false;
            int tot = x + y;
            if (tot % 2 == 0) {
                // 1 even
                int evn_l = x - 1;
                int odd_l = y - evn_l;
                if (evn_l < 0 || odd_l < 0 || odd_l % 2 == 0)
                    valid = false;

                for (int i = 1; i <= evn_l; i++) {
                    list.add(new int[] { 1, i + 1 });
                }
                for (int i = 1; i <= evn_l; i++) {
                    list.add(new int[] { i + 1, i + 1 + evn_l });
                }
                if (odd_l > 0) {
                    int pivot = 2 * evn_l + 2;
                    list.add(new int[] { 1, pivot });
                    odd_l--;
                    for (int i = pivot + 1; i <= odd_l + pivot; i++) {
                        list.add(new int[] { pivot, i });
                    }
                }
            } else {
                // 1 odd
                int odd_l = y - 1 - x;
                int evn_l = x;
                if (evn_l < 0 || odd_l < 0 || odd_l % 2 == 1)
                    valid = false;

                for (int i = 1; i <= evn_l; i++) {
                    list.add(new int[] { 1, i + 1 });
                }
                for (int i = 1; i <= evn_l; i++) {
                    list.add(new int[] { i + 1, i + 1 + evn_l });
                }

                for (int i = 2 * evn_l + 2; i < 2 * evn_l + 2 + odd_l; i++) {
                    list.add(new int[] { 1, i });
                }
            }

            if (valid) {
                System.out.println("YES");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
                }
            } else {
                System.out.println("NO");
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