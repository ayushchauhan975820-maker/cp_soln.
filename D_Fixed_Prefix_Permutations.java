import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class D_Fixed_Prefix_Permutations {
    static final int mod = (int) 1e9 + 7;

    public static class Trie {
        Trie[] children;

        public Trie(int m) {
            this.children = new Trie[m + 1];
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            HashSet<String> set = new HashSet<>();
            int a[][] = new int[n][m + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= m; j++) {
                    a[i][j] = fs.nextInt();
                }
            }
            Trie root = new Trie(m);
            int b[] = new int[m + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= m; j++) {
                    b[a[i][j]] = j;
                }

                Trie cur = root;
                for (int j = 1; j <= m; j++) {
                    int val = b[j];
                    if (cur.children[val] == null) {
                        cur.children[val] = new Trie(m);
                    }
                    cur = cur.children[val];
                }
            }

            int ans[] = new int[n];
            for (int i = 0; i < n; i++) {
                Trie cur = root;
                int depth = 0;
                for (int j = 1; j <= m; j++) {
                    int val = a[i][j];
                    if (cur.children[val] != null) {
                        depth++;
                        cur = cur.children[val];
                    } else {
                        break;
                    }
                }
                ans[i] = depth;
            }

            for (int i = 0; i < n; i++) {
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