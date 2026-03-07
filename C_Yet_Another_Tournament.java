import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Yet_Another_Tournament {
    static final int mod = (int) 1e9 + 7;
    static int n, m, a[];
    static ArrayList<int[]> list;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            m = fs.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new int[] { i + 1, a[i] });
            }
            Collections.sort(list, (x, y) -> {
                if (x[1] == y[1])
                    return x[0] - y[0];
                return x[1] - y[1];
            });

            int l = 1;
            int r = n;
            int ans = n + 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (valid(mid)) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            System.out.println(ans);
        }
    }

    public static boolean valid(int rank) {
        // person currently holding position rank
        int cur_holder = n - rank + 1;

        boolean found = false;
        int count = 0;
        int minutes = m;
        for (int i = 0; i < n; i++) {
            if (list.get(i)[1] > minutes) {
                break;
            }

            minutes -= list.get(i)[1];
            count++;
        }
        if (count >= cur_holder) {
            return true;
        }
        minutes = m;
        if (minutes >= a[cur_holder - 1]) {
            minutes -= a[cur_holder - 1];
            found = true;
            count = 0;
        }
        for (int i = 0; i < n; i++) {
            if (list.get(i)[0] == cur_holder)
                continue;
            if (list.get(i)[1] > minutes) {
                break;
            }

            minutes -= list.get(i)[1];
            count++;
        }
        if (found && count >= cur_holder - 2) {
            return true;
        }
        return false;
    }

    /*
     * a person position be the no of people above it + 1
     * 
     * so let if we want to achieve pos x
     * then we need less then x people above us
     * 
     * now there are two cases let say there is a person currently at xth position
     * (1) i get more win then that person
     * (2) we get equal win to that person but we win against that person
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