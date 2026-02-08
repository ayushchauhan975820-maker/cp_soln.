import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_1_Turtle_and_a_MEX_Problem_Easy_Version {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int high_pos = -1;
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            ArrayList<Integer> ep = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<>();
                int len = fs.nextInt();
                for (int j = 0; j < len; j++) {
                    set.add(fs.nextInt());
                }
                int gap = -1;
                int mex = 0;
                while (set.contains(mex))
                    mex++;
                gap = mex++;
                while (set.contains(mex))
                    mex++;

                if (!map.containsKey(gap)) {
                    map.put(gap, new ArrayList<>());
                }
                ep.add(gap);
                map.get(gap).add(mex);
                high_pos = Math.max(high_pos, mex);
            }

            int[] dp = new int[high_pos + 1];
            dp[high_pos] = high_pos;
            for (int i = high_pos - 1; i >= 0; i--) {
                dp[i] = i;
                if (!map.containsKey(i))
                    continue;

                for (int idx : map.get(i)) {
                    dp[i] = Math.max(dp[idx], dp[i]);
                }
            }

            long best_rch = 0;
            for (int sn : ep) {
                best_rch = Math.max(best_rch, dp[sn]);
            }

            long sum = 0;
            for (int i = 0; i <= Math.min(high_pos, m); i++) {
                sum += max(i, best_rch);
            }

            long rest = 0;
            if (high_pos < m) {
                rest = ((long) m * (m + 1)) / 2 - ((long) high_pos * (high_pos + 1)) / 2;
            }

            sum += rest;
            System.out.println(sum);
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