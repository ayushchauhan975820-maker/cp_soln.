import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Darius_Wisdom {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int ct[] = new int[3];
            int a[] = new int[n];
            boolean sorted = true;
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
                ct[a[i]]++;
                if (i > 0 && a[i] < a[i - 1]) {
                    sorted = false;
                }
            }

            if (sorted) {
                System.out.println(0);
                continue;
            }

            PriorityQueue<Integer> two_idx = new PriorityQueue<>();
            TreeSet<Integer> one_idx = new TreeSet<>();
            PriorityQueue<Integer> zero_idx = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < n; i++) {
                if (a[i] == 1) {
                    one_idx.add(i);
                } else if (a[i] == 2) {
                    two_idx.offer(i);
                } else {
                    zero_idx.offer(i);
                }
            }
            ArrayList<int[]> ans = new ArrayList<>();
            while (!two_idx.isEmpty()) {
                int idx = two_idx.peek();
                if (idx >= (ct[0] + ct[1])) {
                    two_idx.poll();
                    continue;
                }

                if (!zero_idx.isEmpty() && zero_idx.peek() >= ct[0] + ct[1]) {
                    // swap invalid zero with one
                    int rm_z_idx = zero_idx.poll();
                    int rm_o_idx = one_idx.first();
                    one_idx.remove(rm_o_idx);

                    zero_idx.add(rm_o_idx);
                    one_idx.add(rm_z_idx);
                    ans.add(new int[] { rm_o_idx + 1, rm_z_idx + 1 });
                }

                // swap invalid one with two
                if (!one_idx.isEmpty()) {
                    int last = one_idx.last();
                    one_idx.remove(last);
                    int rm_two_idx = two_idx.poll();

                    one_idx.add(rm_two_idx);
                    two_idx.add(last);
                    ans.add(new int[] { rm_two_idx + 1, last + 1 });
                }
            }

            // fix one idx
            while (!one_idx.isEmpty()) {
                int first = one_idx.first();
                one_idx.remove(first);
                if (first >= ct[0])
                    continue;

                int rm_z_idx = zero_idx.poll();
                one_idx.add(rm_z_idx);
                zero_idx.offer(first);
                ans.add(new int[] { first + 1, rm_z_idx + 1 });
            }

            System.out.println(ans.size());
            for (int i = 0; i < ans.size(); i++) {
                System.out.println(ans.get(i)[0] + " " + ans.get(i)[1]);
            }
        }
    }

    /*
     * so we will swap 0's -> 1's and 1's -> 2's
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