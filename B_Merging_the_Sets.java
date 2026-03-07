import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class B_Merging_the_Sets {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
                int li = fs.nextInt();
                for (int j = 0; j < li; j++) {
                    int val = fs.nextInt();
                    list.get(i).add(val);
                    map.put(val, map.getOrDefault(val, 0) + 1);
                }
            }

            int replacable = 0;
            for (int i = 0; i < n; i++) {
                int li = list.get(i).size();
                boolean single = false;
                for (int j = 0; j < li; j++) {
                    int val = list.get(i).get(j);
                    if (map.get(val) == 1) {
                        single = true;
                    }
                }
                if (!single)
                    replacable++;
            }

            if (map.size() == m && replacable >= 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    /*
     * so we want either 2 extra sets or 2 sets that are replacable to each other
     * 
     * this is extra if only we have a set that can fulfill out needs
     * if there is an element whose frequency is only one then it must be in the set
     * and cannot be replaced
     * 
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