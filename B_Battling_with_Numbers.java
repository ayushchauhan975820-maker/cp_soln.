import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class B_Battling_with_Numbers {

    static final long MOD = 998244353;

    static long modPow(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1)
                res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }

    public static void main(String[] args) {

        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        HashMap<Integer, Integer> x = new HashMap<>();
        HashMap<Integer, Integer> y = new HashMap<>();
        HashMap<Integer, Integer> x_y = new HashMap<>();
        int a[] = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
            x.put(a[i], b[i]);
        }

        int m = sc.nextInt();
        int c[] = new int[m];
        int d[] = new int[m];

        for (int i = 0; i < m; i++) {
            c[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            d[i] = sc.nextInt();
            y.put(c[i], d[i]);
            int val = x.getOrDefault(c[i], 0) - d[i];
            if (val != 0) {
                x_y.put(c[i], val);
            }
        }

        int count = 1;
        for (int val : x_y.values()) {
            if (val < 0) {
                count = 0;
                break;
            } else {
                count = 2;
            }
        }

        for (int key : x.keySet()) {
            if (!y.containsKey(key)) {
                x_y.put(key, x.get(key));
                if (count > 0) {
                    count = 2;
                }
            }
        }

        if (count == 0) {
            out.println(0);
        } else if (count == 1) {
            out.println(1);
        } else {
            long ans = modPow(2, x_y.size(), MOD);
            out.println(ans);
        }

        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}