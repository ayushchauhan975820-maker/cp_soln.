import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Guess_The_Tree {
    static final int mod = (int) 1e9 + 7;
    public static boolean vis[];
    public static ArrayList<ArrayList<Integer>> list;
    public static FastScanner fs;

    public static void main(String[] args) throws Exception {
        fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            vis = new boolean[n + 1];
            list = new ArrayList<>();
            vis[1] = true;
            for (int i = 2; i <= n; i++) {
                if (vis[i])
                    continue;
                dac(1, i);
            }

            System.out.print("! ");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).get(0) + " " + list.get(i).get(1) + " ");
            }
            System.out.println();
            System.out.flush();
        }
    }

    public static void dac(int s, int e) throws Exception {
        if (s == e)
            return;
        // get mid
        System.out.println("? " + s + " " + e);
        System.out.flush();
        int mid = fs.nextInt();
        if (mid == s) {
            vis[s] = true;
            vis[e] = true;
            list.add(new ArrayList<>());
            list.get(list.size() - 1).add(s);
            list.get(list.size() - 1).add(e);
            return;
        }

        if (!vis[mid]) {
            dac(s, mid);
        }

        dac(mid, e);
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