import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class DMishkinEnergizer {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            char ch[] = s.toCharArray();
            int a[] = new int[n];
            int ct[] = new int[5];
            for (int i = 0; i < n; i++) {
                if (ch[i] == 'L')
                    a[i] = 1;
                else if (ch[i] == 'I')
                    a[i] = 2;
                else
                    a[i] = 4;

                ct[a[i]]++;
            }
            if (ct[1] == n || ct[2] == n || ct[4] == n) {
                System.out.println(-1);
                continue;
            }

            ArrayList<Integer> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder(s);

            for (int i = 0; i < 2 * n; i++) {
                int idx1 = -1;
                int idx2 = -1;
                int ctl = 0;
                int cti = 0;
                int ctt = 0;
                for (int j = 0; j < sb.length(); j++) {
                    if (sb.charAt(j) == 'L')
                        ctl++;
                    else if (sb.charAt(j) == 'I')
                        cti++;
                    else
                        ctt++;
                }
                if (ctl == cti && ctl == ctt)
                    break;
                char mn = (cti <= ctl && cti <= ctt) ? 'I' : (ctl <= cti && ctl <= ctt) ? 'L' : 'T';

                for (int j = 0; j < sb.length() - 1; j++) {
                    if (sb.charAt(j) != mn && sb.charAt(j + 1) != mn && sb.charAt(j) != sb.charAt(j + 1)) {
                        idx1 = j;
                        break;
                    }
                    if ((sb.charAt(j) == mn || sb.charAt(j + 1) == mn)
                            && !(sb.charAt(j) == mn && sb.charAt(j + 1) == mn)) {
                        idx2 = j;
                    }
                }

                if (idx1 != -1) {
                    list.add(idx1);
                    sb.insert(idx1 + 1, mn);
                } else {
                    list.add(idx2);
                    char ins[] = { 'L', 'I', 'T' };
                    int idx = 0;
                    for (int k = 0; k < 3; k++) {
                        if (ins[k] != sb.charAt(idx2) && ins[k] != sb.charAt(idx2 + 1)) {
                            idx = k;
                        }
                    }
                    sb.insert(idx2 + 1, ins[idx]);
                }
            }

            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i) + 1);
            }
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