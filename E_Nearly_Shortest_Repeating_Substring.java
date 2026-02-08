import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E_Nearly_Shortest_Repeating_Substring {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            // calculating divisors
            ArrayList<Integer> div = new ArrayList<>();
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    div.add(i);
                    int dv = n / i;
                    if (dv != i) {
                        div.add(dv);
                    }
                }
            }
            Collections.sort(div);

            // finding smallest k
            int k = n;
            for (int i = 0; i < div.size() - 1; i++) {
                int divisor = div.get(i);
                // for each alpha in k iterate over
                boolean invalid = false;
                int ct = 0;
                for (int j = 0; j < divisor; j++) {
                    HashMap<Integer, Integer> mp = new HashMap<>();
                    char ch = s.charAt(j);
                    mp.put(ch - 'a', 1);
                    for (int l = j + divisor; l < n; l += divisor) {
                        char comp = s.charAt(l);
                        mp.put(comp - 'a', mp.getOrDefault(comp - 'a', 0) + 1);
                    }
                    if (mp.size() > 2) {
                        invalid = true;
                        break;
                    } else if (mp.size() == 2) {
                        ct++;
                        int count = mp.get(ch - 'a');
                        int dv = n / divisor;
                        if (!(count == 1 || count == dv - 1)) {
                            invalid = true;
                            break;
                        }
                    }
                }

                if (!invalid && ct <= 1) {
                    k = divisor;
                    break;
                }
            }

            System.out.println(k);
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