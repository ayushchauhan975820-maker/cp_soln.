import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class F_Mooclear_Reactor_2 {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
                return x - y;
            });
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                int x = fs.nextInt();
                int y = fs.nextInt();
                list.get(y).add(x);
            }

            int a[][] = new int[m + 1][2];
            for (int i = 1; i <= m; i++) {
                a[i][0] = fs.nextInt();
                a[i][1] = fs.nextInt();
            }

            long dp[] = new long[n + 1];
            int last[] = new int[n + 1];
            long sum = 0;
            for (int i = n; i >= 0; i--) {
                for (int j = 0; j < list.get(i).size(); j++) {
                    sum += list.get(i).get(j);
                    pq.offer(list.get(i).get(j));
                }
                while (pq.size() > i + 1) {
                    sum -= pq.poll();
                }
                if (pq.isEmpty() || pq.size() < i + 1) {
                    last[i] = -1;
                } else {
                    last[i] = pq.peek();
                }
                dp[i] = sum;
            }
            long gb_max = dp[0];
            for (int i = 1; i <= n; i++) {
                gb_max = max(gb_max, dp[i]);
            }

            long open[] = new long[n + 1];
            open[0] = (last[0] == -1) ? dp[0] : (dp[0] - last[0]);
            for (int i = 1; i <= n; i++) {
                long current = (last[i] == -1) ? dp[i] : (dp[i] - last[i]);
                open[i] = Math.max(open[i - 1], current);
            }

            for (int i = 1; i <= m; i++) {
                int val = a[i][0];
                int idx = a[i][1];
                long s = max(gb_max, dp[idx]);
                s = max(s, open[idx] + val);
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    /*
     * for for each particle in the shop find the maximum subset to the energy she
     * can choose
     * 
     * she can include that particle if she wants
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