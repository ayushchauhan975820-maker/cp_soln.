import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Lucky_Chains {
    static final int mod = (int) 1e9 + 7;

    public static long seive[] = new long[(int) 1e7 + 2];

    public static void calc() {
        seive[1] = 1;
        int n = seive.length;
        for (int i = 2; i * i < n; i++) {
            if (seive[i] != 0)
                continue;
            seive[i] = i;
            for (int j = i * i; j < n; j += i) {
                if (seive[j] == 0)
                    seive[j] = i;
            }
        }

        for (int i = 2; i < n; i++) {
            if (seive[i] == 0) {
                seive[i] = i;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        calc();
        int n = fs.nextInt();
        for (int i = 0; i < n; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();

            int dif = abs(b - a);
            if (dif == 1) {
                System.out.println(-1);
                continue;
            }
            ArrayList<Long> list = getFact(dif);
            long ans = Integer.MAX_VALUE;
            for (long fact : list) {
                ans = Math.min(ans, (fact - (a % fact)) % fact);
            }

            System.out.println(ans);
        }
    }

    public static ArrayList<Long> getFact(int no) {
        HashSet<Long> set = new HashSet<>();
        ArrayList<Long> list = new ArrayList<>();
        while (no != 1) {
            long val = seive[no];
            set.add(val);
            no /= val;
        }
        for (long val : set)
            list.add(val);
        Collections.sort(list);
        return list;
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