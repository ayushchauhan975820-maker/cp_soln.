import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class G_Mixing_MEXes {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int len = fs.nextInt();
                list.add(new ArrayList<>());
                for (int j = 0; j < len; j++) {
                    list.get(i).add(fs.nextInt());
                }
            }
            long tot_mex_sum = 0;
            HashMap<Integer, Integer> org_mex = new HashMap<>();
            HashMap<Integer, Integer> new_mex = new HashMap<>();
            HashMap<Integer, ArrayList<Integer>> mex = new HashMap<>();
            HashMap<Integer, HashSet<Integer>> ch_drop = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int len = list.get(i).size();
                HashMap<Integer, Integer> calc = new HashMap<>();
                ch_drop.put(i, new HashSet<>());
                for (int j = 0; j < len; j++) {
                    calc.put(list.get(i).get(j), calc.getOrDefault(list.get(i).get(j), 0) + 1);
                }

                int gap = 0;
                while (calc.containsKey(gap)) {
                    if (calc.get(gap) == 1) {
                        ch_drop.get(i).add(gap);
                    }
                    gap++;
                }

                org_mex.put(i, gap);
                if (mex.containsKey(gap)) {
                    mex.put(gap, new ArrayList<>());
                }
                mex.get(gap).add(i);
                gap = gap + 1;
                while (calc.containsKey(gap)) {
                    gap++;
                }

                new_mex.put(i, gap);
            }

            for (int val : org_mex.values()) {
                tot_mex_sum += val;
            }

            long tot = 0;
            for (int i = 0; i < n; i++) {
                int len = list.get(i).size();

                for (int j = 0; j < len; j++) {
                    int val = list.get(i).get(j);
                    // remove val
                    long sum = 0;
                    int ct = 0;
                    if (mex.containsKey(val)) {
                        ct = mex.get(val).size();
                        for (int idx : mex.get(val)) {
                            sum += new_mex.get(idx);
                        }
                    }

                    boolean rem = ch_drop.get(i).contains(val);

                    tot += (n - 1) * (tot_mex_sum - (rem ? val : 0)) - (ct * val) + sum;
                }
            }

            System.out.println(tot);
        }
    }

    /*
     * so if we notice in most of the cases mex is not going to change
     * 
     * mex of some k will change on addition aij if aij is the mex of that array
     * and mex of this array will change if it is lesser than mex and only one of it
     * exists
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