import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Simons_and_Posting_Blogs {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int inf = (int) (1e9 / 2);
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int max = 0;
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
                int m = fs.nextInt();
                max = max(max, m);
                for (int j = 0; j < m; j++) {
                    list.get(i).add(fs.nextInt());
                }
            }

            ArrayList<Integer>[] a = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                a[i] = new ArrayList<>();
                HashSet<Integer> set = new HashSet<>();
                for (int j = list.get(i).size() - 1; j >= 0; j--) {
                    int val = list.get(i).get(j);
                    if (!set.contains(val)) {
                        a[i].add(val);
                        set.add(val);
                    }
                }
            }

            boolean used[] = new boolean[n + 1];
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int best = -1;
                for (int j = 0; j < n; j++) {
                    int p1 = 0;
                    int p2 = 0;
                    if (used[j])
                        continue;
                    if (best == -1) {
                        best = j;
                        continue;
                    }
                    while (true) {
                        while (p1 < a[j].size() && set.contains(a[j].get(p1)))
                            p1++;
                        while (p2 < a[best].size() && set.contains(a[best].get(p2)))
                            p2++;

                        if (p1 == a[j].size() && p2 == a[best].size()) {
                            break;
                        }
                        if (p1 == a[j].size()) {
                            best = j;
                            break;
                        }
                        if (p2 == a[best].size()) {
                            break;
                        }

                        int v1 = a[j].get(p1);
                        int v2 = a[best].get(p2);
                        if (v1 != v2) {
                            if (v1 < v2)
                                best = j;
                            break;
                        }
                        p1++;
                        p2++;
                    }
                }
                used[best] = true;
                for (int j = 0; j < a[best].size(); j++) {
                    if (!set.contains(a[best].get(j))) {
                        set.add(a[best].get(j));
                        System.out.print(a[best].get(j) + " ");
                    }
                }
            }

            System.out.println();
        }
    }

    /*
     * so at the end Q will be all the distict users in the matrix
     * 
     * choose an i
     * for each idx from 1 to j
     * if aij already exist bubble up
     * else append to the beggining
     * 
     * create in lexicographical smallest order
     * 
     * the elements in the ans is will be from the first row only so select the best
     * row in each step without duplicates
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