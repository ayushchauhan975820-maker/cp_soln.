import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Action_Figures {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            int ct = 0;
            TreeSet<Integer> av = new TreeSet<>();
            TreeSet<Integer> pckable = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    pckable.add(i);
                } else
                    av.add(i);
            }
            long sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (s.charAt(i) == '0')
                    continue;

                Integer avail = av.lower(i);

                if (avail != null) {
                    sum += avail + 1;
                    av.remove(avail);
                    pckable.remove(i);
                } else {
                    Integer pck = pckable.last();
                    if (pck != null) {
                        sum += pck + 1;
                        pckable.remove(pck);
                        pckable.remove(i);
                    } else {
                        pckable.remove(i);
                        sum += i + 1;
                    }
                }
            }

            while (!av.isEmpty()) {
                sum += av.pollFirst() + 1;
            }
            while (!pckable.isEmpty()) {
                sum += pckable.pollFirst() + 1;
            }

            System.out.println(sum);

        }
    }

    /*
     * last is i so we can buy all the figs here
     * ith fig has cost i
     * 
     * let say we have n buy days then we can at max get n items free
     * x figs
     * min(i, x/2)
     * 
     * for every pick we have to make sure that there is atleast 1 number more
     * lesser then this
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