import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Do_You_Love_Your_Hero_and_His_Two_Hit_Multi_Target_Attacks {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int k = fs.nextInt();
            if (k == 0) {
                System.out.println(1);
                System.out.println(0 + " " + 0);
                continue;
            }

            ArrayList<int[]> list = new ArrayList<>();
            int toleft = k;
            int f = 1;
            int s = 1;
            while (toleft > 0) {
                int n = 2;
                for (int i = 3; i < 500; i++) {
                    if ((i * (i - 1)) / 2 <= toleft) {
                        n = i;
                    } else {
                        break;
                    }
                }

                for (int i = 1; i <= n; i++) {
                    list.add(new int[] { f, s++ });
                }
                f++;
                toleft -= (n * (n - 1)) / 2;
            }

            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
            }
        }
    }

    /*
     * make a = 0 (x2 - x1) or b = (y2 - y1)
     * 
     * (1, 1)(1, 2)
     * (2,3) (2,4)
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