import java.io.*;
import java.util.*;

public class C_Theofanis_Nightmare {
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
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
            int c = read();
            while (c <= ' ' && c != -1) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] arr = new int[n];
            long[] suf = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
            }
            suf[n - 1] = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                suf[i] = suf[i + 1] + (long) arr[i];
            }

            int part = 1;
            long ans = (long) arr[0];
            for (int i = 1; i < n; i++) {
                if (suf[i] > 0) {
                    part++;
                }
                ans += part * (long) arr[i];
            }
            sb.append(ans).append('\n');
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        out.print(sb.toString());
        out.flush();
    }
}
