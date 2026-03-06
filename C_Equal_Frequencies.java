import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Equal_Frequencies {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            char ch[] = fs.next().toCharArray();
            int ct[] = new int[26];
            for (int i = 0; i < n; i++) {
                ct[ch[i] - 'a']++;
            }
            int best = -1;
            int min = Integer.MAX_VALUE;
            ArrayList<Integer> div = new ArrayList<>();
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    if (26 * i >= n) {
                        div.add(i);
                    }
                    if (i != n / i) {
                        if (26 * (n / i) >= n) {
                            div.add(n / i);
                        }
                    }
                }
            }

            Collections.sort(div);
            for (int freq : div) {
                // find the best possible combinations of characters
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                for (int i = 0; i < 26; i++) {
                    pq.offer(ct[i]);
                }
                int tot = 0;
                int char_needed = n / freq;
                while (char_needed > 0 && !pq.isEmpty()) {
                    int count = pq.poll();
                    if (count < freq) {
                        tot += freq - count;
                    }
                    char_needed--;
                }

                if (tot < min) {
                    min = tot;
                    best = freq;
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
            for (int i = 0; i < 26; i++) {
                pq.offer(new int[] { i, ct[i] });
            }
            StringBuilder sb = new StringBuilder();
            boolean chosen[] = new boolean[26];
            Queue<Integer> q = new LinkedList<>();

            int ele = n / best;

            for (int i = 0; i < ele; i++) {
                int[] arr = pq.poll();
                chosen[arr[0]] = true;

                int def = Math.max(0, best - arr[1]);
                for (int j = 0; j < def; j++) {
                    q.offer(arr[0]);
                }
            }

            int kept[] = new int[26];
            for (int i = 0; i < n; i++) {
                int idx = ch[i] - 'a';

                if (chosen[idx] && kept[idx] < best) {
                    sb.append(ch[i]);
                    kept[idx]++;
                } else {
                    int val = q.poll();
                    sb.append((char) (val + 'a'));
                }
            }

            System.out.println(min);
            System.out.println(sb.toString());
        }
    }

    /*
     * so frequency will be divisor of n
     * also 26 * divisor must be greater than or equal to n
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