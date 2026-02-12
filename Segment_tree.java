import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class Segment_tree {
    static final int mod = (int) 1e9 + 7;
    public static long tree[];

    public static long f(int node, int q_left, int q_right, int r_left, int r_right) {
        // if whole range lie in it
        if (q_left >= r_left && r_right <= q_right) {
            return tree[node];
        }
        // if disjoint
        if (q_left > r_right || q_right < r_left) {
            return 0;
        }

        // return sum of left and right
        int nxt_range = (r_left + r_right) / 2;
        return f(2 * node, q_left, q_right, r_left, nxt_range) +
                f(2 * node + 1, q_left, q_right, nxt_range + 1, r_right);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int q = fs.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(fs.nextInt());
            }
            // padding 0 to make it power of 2
            while ((a.size() & (a.size() - 1)) != 0) {
                a.add(0);
            }
            n = a.size();
            tree = new long[2 * n];

            // build tree
            // fill tree indices n - (2 * n - 1)
            for (int i = 0; i < n; i++) {
                tree[n + i] = a.get(i);
            }
            // go from n to 1
            for (int i = n - 1; i >= 1; i--) {
                // since this is sum
                tree[i] = (long) tree[2 * i] + tree[2 * i + 1];
            }

            // debug(tree);
            for (int i = 0; i < q; i++) {
                int l = fs.nextInt() - 1;
                int r = fs.nextInt() - 1;

                long ans = f(1, l, r, 0, n - 1);
                System.out.println(ans);
            }
        }
    }

    public static void debug(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return;
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