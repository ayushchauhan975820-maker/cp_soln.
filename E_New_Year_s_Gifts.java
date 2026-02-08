import java.io.*;
import java.util.*;

public class E_New_Year_s_Gifts {
    static final int mod = (int) 1e9 + 7;

    public static class Pair {
        int bt;
        int dif;

        public Pair(int bt, int dif) {
            this.bt = bt;
            this.dif = dif;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            long k = fs.nextLong();
            int a[] = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = fs.nextInt();
            }
            Arrays.sort(a);
            long y = 0;
            Pair b[] = new Pair[n];
            for (int i = 0; i < n; i++) {
                int xi = fs.nextInt();
                int yi = fs.nextInt();
                int zi = fs.nextInt();
                y += yi;
                b[i] = (new Pair(xi, zi - yi));
            }
            long ext = k - y;
            int ans = 0;
            Arrays.sort(b, (p1, p2) -> Integer.compare(p1.bt, p2.bt));
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>((p1, p2) -> Integer.compare(p2.dif, p1.dif));
            int idx = 0;
            for (int i = 0; i < m; i++) {
                while (idx < n && b[idx].bt <= a[i]) {
                    pq.offer(b[idx++]);
                }
                if (!pq.isEmpty()) {
                    pq.poll();
                    ans++;
                }
            }

            PriorityQueue<Integer> rst = new PriorityQueue<>();

            while (!pq.isEmpty())
                rst.offer(pq.poll().dif);
            while (idx < n)
                rst.offer(b[idx++].dif);

            while (!rst.isEmpty() && rst.peek() <= ext) {
                ans++;
                ext -= rst.peek();
                rst.poll();
            }

            System.out.println(ans);
        }
    }

    /*
     * m box -> each box beauty ai
     * 
     * each gift is atleast yi
     * friend will be happy ->
     * (i) beauty of box is ai >= xi
     * (ii) cost ci >= zi
     * 
     * add = (k - yi * n)
     * 
     * add must not go to people whose beauty is satisfied
     * zi - yi
     * 
     * 
     */

    // fast scanner
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