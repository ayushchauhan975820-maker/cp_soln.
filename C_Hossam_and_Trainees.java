import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Hossam_and_Trainees {
    static final int mod = (int) 1e9 + 7;
    public static boolean seive[] = new boolean[(int) (1e5 + 2)];
    public static ArrayList<Integer> prime = new ArrayList<>();

    public static void calc() {
        for (int i = 2; i * i < (int) (1e5 + 2); i++) {
            if (seive[i])
                continue;
            for (int j = i * i; j < (int) (1e5 + 2); j += i) {
                seive[j] = true;
            }
        }
        for (int i = 2; i < (int) (1e5 + 2); i++) {
            if (!seive[i])
                prime.add(i);
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        calc();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }

            boolean valid = true;
            HashSet<Integer> div = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int val = a[i];
                for (int j = 0; j < prime.size(); j++) {
                    int divisor = prime.get(j);
                    if ((long) divisor * divisor > val)
                        break;
                    if (val % divisor == 0) {
                        if (div.contains(divisor)) {
                            valid = false;
                            break;
                        }
                        div.add(divisor);

                        while (val % divisor == 0) {
                            val /= divisor;
                        }
                    }
                }

                if (val > 1) {
                    if (div.contains(val)) {
                        valid = false;
                    } else {
                        div.add(val);
                    }
                }

                if (!valid)
                    break;
            }

            if (!valid)
                System.out.println("YES");
            else
                System.out.println("NO");
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