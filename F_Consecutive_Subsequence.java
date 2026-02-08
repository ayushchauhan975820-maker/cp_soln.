import java.util.*;
import java.io.*;

public class F_Consecutive_Subsequence {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }

        HashMap<Integer, Integer> dp = new HashMap<>();

        HashMap<Integer, Integer> lastIndex = new HashMap<>();
        int[] parent = new int[n];

        int bestLen = 0;
        int bestVal = 0;

        for (int i = 0; i < n; i++) {
            int x = a[i];

            int len = dp.getOrDefault(x - 1, 0) + 1;
            dp.put(x, len);

            parent[i] = lastIndex.getOrDefault(x - 1, -1);
            lastIndex.put(x, i);

            if (len > bestLen) {
                bestLen = len;
                bestVal = x;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int idx = lastIndex.get(bestVal);

        while (idx != -1) {
            result.add(idx + 1);
            idx = parent[idx];
        }

        Collections.reverse(result);

        System.out.println(bestLen);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    // ---------- FastScanner ----------
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
    }
}