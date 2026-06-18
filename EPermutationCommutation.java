import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class EPermutationCommutation {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n + 1];
            int b[] = new int[n + 1];
            int pos[] = new int[n + 1];
            int freq[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
                pos[a[i]] = i;
            }
            for (int i = 1; i <= n; i++) {
                b[i] = fs.nextInt();
            }

            Queue<int[]> q = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                if (b[i] != -1) {
                    q.offer(new int[] { b[i], i });
                    freq[b[i]]++;
                }
            }

            boolean valid = true;
            while (!q.isEmpty() && valid) {
                int cur[] = q.poll();
                int val = cur[0];
                int ai = cur[1];
                int bi = pos[val];

                int pos_ai = pos[ai];
                if (b[pos_ai] == bi)
                    continue;

                if (b[pos_ai] != -1)
                    valid = false;
                b[pos_ai] = bi;
                freq[bi]++;
                q.offer(new int[] { bi, pos_ai });
            }

            for (int i = 1; i <= n; i++) {
                if (freq[i] > 1)
                    valid = false;
            }

            if (!valid) {
                System.out.println("NO");
                continue;
            } else {
                System.out.println("YES");
            }
            for (int i = 1; i <= n; i++)
                System.out.print(a[i] + "  ");
            System.out.println();
            for (int i = 1; i <= n; i++)
                System.out.print(b[i] + "  ");
            System.out.println();
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