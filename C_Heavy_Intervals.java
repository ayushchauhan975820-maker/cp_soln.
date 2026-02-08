import java.io.*;
import java.util.*;

public class C_Heavy_Intervals {
    private static final class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
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
            do {
                c = readByte();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            int[] c = new int[n];
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }
            for (int i = 0; i < n; i++) {
                b[i] = fs.nextInt();
            }
            for (int i = 0; i < n; i++) {
                c[i] = fs.nextInt();
            }

            Arrays.sort(b);
            Arrays.sort(c);

            int[] diff = new int[n];
            for (int i = 0; i < n; i++) {
                int key = map.lowerKey(b[i]);
                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }

                diff[i] = b[i] - key;
            }
            Arrays.sort(diff);

            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans += (long) c[n - 1 - i] * diff[i];
            }

            out.append(ans).append('\n');
        }

        System.out.print(out.toString());
    }
}
