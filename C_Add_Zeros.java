import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Add_Zeros {
    static final int mod = (int) 1e9 + 7;
    public static HashMap<Long, HashSet<Integer>> map = new HashMap<>();;
    public static HashSet<Long> vis = new HashSet<>();

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            long n = fs.nextLong();
            fs.nextInt();

            map.clear();
            vis.clear();
            for (int i = 2; i <= n; i++) {
                long des_len = fs.nextLong() - 1L + i;
                if (!map.containsKey(des_len)) {
                    map.put(des_len, new HashSet<>());
                }
                map.get(des_len).add(i);
            }
            long max = n;
            Queue<Long> q = new LinkedList<>();
            q.offer(n);
            while (!q.isEmpty()) {
                long val = q.poll();
                if (!map.containsKey(val))
                    continue;
                for (int idx : map.get(val)) {
                    long nl = val + idx - 1;
                    if (!vis.contains(nl)) {
                        max = Math.max(max, nl);
                        q.offer(nl);
                        vis.add(nl);
                    }
                }
            }

            System.out.println(max);
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