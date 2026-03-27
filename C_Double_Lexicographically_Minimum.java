import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_Double_Lexicographically_Minimum {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();
        while (t-- > 0) {
            String s = fs.next();
            int n = s.length();
            int ct[] = new int[26];
            for (int i = 0; i < n; i++) {
                ct[s.charAt(i) - 'a']++;
            }

            char ans[] = new char[n];
            int idx = 0;
            int lst = n - 1;
            for (int i = 0; i < 26; i++) {
                if (ct[i] == 0)
                    continue;

                char ch = (char) (i + 'a');
                if (ct[i] % 2 == 0) {
                    // fill symmetriclly
                    int len = ct[i] / 2;
                    for (int j = idx; j < idx + len; j++) {
                        ans[j] = ch;
                    }
                    idx = idx + len;
                    for (int j = lst; j > lst - len; j--) {
                        ans[j] = ch;
                    }
                    lst = lst - len;
                } else {
                    while (ct[i] > 1) {
                        ans[idx++] = ch;
                        ans[lst--] = ch;
                        ct[i] -= 2;
                    }

                    int dist = 0;
                    int lst_idx = -1;
                    for (int j = i + 1; j < 26; j++) {
                        if (ct[j] != 0) {
                            dist++;
                            lst_idx = j;
                        }
                    }

                    if (dist == 0) {
                        ans[idx++] = ch;
                    } else if (dist == 1) {
                        // distribute lst_idx equally and then idx
                        char y = (char) (lst_idx + 'a');
                        int left_y = (ct[lst_idx] + 1) / 2;
                        int right_y = ct[lst_idx] / 2;

                        for (int j = 0; j < left_y; j++)
                            ans[idx++] = y;
                        ans[idx++] = ch;

                        for (int j = 0; j < right_y; j++)
                            ans[lst--] = y;
                    } else {
                        ans[lst] = ch;
                        for (int j = i + 1; j < 26; j++) {
                            while (ct[j] > 0) {
                                char y = (char) (j + 'a');
                                ans[idx++] = y;
                                ct[j]--;
                            }
                        }
                    }
                    break;
                }
            }

            for (char ch : ans) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    /*
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