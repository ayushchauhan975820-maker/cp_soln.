import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class FGravityFalls {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ls.add(new ArrayList<>());
            }
            int mx = 0;
            HashSet<Integer> av = new HashSet<>();
            for (int i = 0; i < n; i++) {
                av.add(i);
                int k = fs.nextInt();
                mx = Math.max(mx, k);
                for (int j = 0; j < k; j++) {
                    int val = fs.nextInt();
                    ls.get(i).add(val);
                }
            }
            int ans[] = new int[mx];
            int idx = 0;

            while (idx < mx && !av.isEmpty()) {
                HashSet<Integer> set = new HashSet<>();
                for (int item : av) {
                    set.add(item);
                }
                int srch = idx;
                int to_put = -1;
                while (to_put == -1) {
                    ArrayList<int[]> list = new ArrayList<>();
                    for (int item : set) {
                        if (ls.get(item).size() > srch) {
                            list.add(new int[] { ls.get(item).get(srch), item });
                        } else {
                            to_put = item;
                            break;
                        }
                    }
                    if (to_put != -1)
                        break;
                    int mn = (int) (1e7);
                    int id = -1;
                    for (int i = 0; i < list.size(); i++)
                        mn = min(mn, list.get(i)[0]);

                    set = new HashSet<>();
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i)[0] == mn) {
                            set.add(list.get(i)[1]);
                            id = list.get(i)[1];
                        }
                    }

                    if (set.size() == 1) {
                        to_put = id;
                        break;
                    }

                    srch++;
                }

                while (idx < ls.get(to_put).size()) {
                    ans[idx] = ls.get(to_put).get(idx);
                    idx++;
                }

                set = new HashSet<>();
                for (int item : av) {
                    if (ls.get(item).size() > idx) {
                        set.add(item);
                    }
                }
                av = set;
            }

            for (int i = 0; i < mx; i++) {
                System.out.print(ans[i] + " ");
            }
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