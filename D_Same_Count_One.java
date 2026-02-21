import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Same_Count_One {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int grid[][] = new int[n + 1][m + 1];
            int tot = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    grid[i][j] = fs.nextInt();
                    if (grid[i][j] == 1)
                        tot++;
                }
            }
            if (tot % n != 0) {
                System.out.println(-1);
                continue;
            }
            int in_row = tot / n;
            Queue<int[][]> extra = new LinkedList<>();
            Deque<int[][]> need = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                int count = 0;
                for (int j = 1; j <= m; j++) {
                    if (grid[i][j] == 1)
                        count++;
                }
                if (count > in_row) {
                    extra.add(new int[][] { { i, count }, grid[i] });
                }
                if (count < in_row) {
                    need.add(new int[][] { { i, count }, grid[i] });
                }
            }
            ArrayList<int[]> ops = new ArrayList<>();
            while (!extra.isEmpty()) {
                int row = extra.peek()[0][0];
                int count = extra.peek()[0][1];
                int arr[] = extra.peek()[1];
                extra.poll();
                while (count > in_row && !need.isEmpty()) {
                    int rown = need.peek()[0][0];
                    int countn = need.peek()[0][1];
                    int ca[] = need.peek()[0];
                    int arrn[] = need.peek()[1];
                    for (int i = 1; i <= m && countn < in_row && count > in_row; i++) {
                        if (arr[i] == 1 && arrn[i] == 0) {
                            count--;
                            arr[i] = 0;
                            arrn[i] = 1;
                            ca[1]++;
                            countn++;
                            ops.add(new int[] { row, rown, i });
                        }
                    }
                    if (countn == in_row)
                        need.poll();
                    else {
                        int aa[][] = need.poll();
                        need.addLast(aa);
                    }
                }
            }

            System.out.println(ops.size());
            for (int i = 0; i < ops.size(); i++) {
                System.out.println(ops.get(i)[0] + " " + ops.get(i)[1] + " " + ops.get(i)[2]);
            }
        }
    }

    /*
     * if i am moving from some x to y then its guarrented that there exist some pos
     * a where 1 has 0 and other has 1
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