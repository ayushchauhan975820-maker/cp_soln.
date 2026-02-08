import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Maximize_the_Root {
    static final int mod = (int) 1e9 + 7;
    public static int a[];
    public static HashMap<Integer, ArrayList<Integer>> map;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
            }
            map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                map.put(i, new ArrayList<>());
            }
            for (int i = 2; i <= n; i++) {
                int par = fs.nextInt();
                map.get(par).add(i);
            }

            long after_inc = dfs(1);
            long ans = a[1] + after_inc;
            System.out.println(ans);
        }
    }

    public static long dfs(int node) {
        long val = a[node];
        int sz = map.get(node).size();
        if (sz == 0)
            return val;

        long min = Long.MAX_VALUE;
        for (int child_node : map.get(node)) {
            min = Math.min(min, dfs(child_node));
        }

        // if this min is less than val can't increase
        if (min <= val)
            return min;

        // increase the current node
        long final_val = (min + val) / 2;
        if (node == 1)
            return min;
        return final_val;
    }

    /*
     * go and find the lowest values of the subtree after op
     * for a current node it can maximize val x and k
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