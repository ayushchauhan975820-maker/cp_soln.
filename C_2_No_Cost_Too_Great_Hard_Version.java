import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class C_2_No_Cost_Too_Great_Hard_Version {
    public static int[] seive = new int[(int) (1e7 + 1)];

    public static void fact() {
        int n = seive.length;
        seive[1] = 1;
        for (int i = 2; i * i < n; i++) {
            if (seive[i] != 0)
                continue;

            seive[i] = i;
            for (int j = i * i; j < n; j += i) {
                if (seive[j] == 0) {
                    seive[j] = i;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (seive[i] == 0)
                seive[i] = i;
        }
    }

    public static HashSet<Integer> getPrimeFactors(int x) {
        HashSet<Integer> primes = new HashSet<>();
        while (x > 1) {
            primes.add(seive[x]);
            x /= seive[x];
        }
        return primes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fact();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int a[] = new int[n];
            int b[] = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            int maxFact = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            HashSet<Integer> set = new HashSet<>();
            boolean gcd = false;
            for (int i = 0; i < n; i++) {
                set = getPrimeFactors(a[i]);
                for (int prime : set) {
                    maxFact = max(maxFact, prime);
                    map.put(prime, map.getOrDefault(prime, 0) + 1);
                    if (map.get(prime) > 1)
                        gcd = true;
                }
                set.clear();
            }

            if (gcd) {
                System.out.println(0);
                continue;
            }

            ArrayList<int[]> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new int[] { a[i], b[i] });
            }
            Collections.sort(list, (x, y) -> x[1] - y[1]);
            long min = list.get(0)[1] + list.get(1)[1];
            long max = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int val = a[i] + 1;
                int cost = b[i];
                set = getPrimeFactors(val);
                for (int prime : set) {
                    if (map.containsKey(prime)) {
                        if ((map.get(prime) == 1 && (val - 1) % prime != 0)) {
                            max = Math.min(max, cost);
                        }
                    }
                }
                set.clear();
            }
            min = min(min, max);
            int val = list.get(0)[0];
            long c = (long) list.get(0)[1];
            for (int prime : map.keySet()) {
                if (val % prime != 0 && map.get(prime) == 1) {
                    int steps = (prime - (val % prime)) % prime;
                    min = Math.min(min, c * steps);
                }
            }
            System.out.println(min);
        }
    }

    /*
     * i - val
     * 
     * to get introduced a fact of rime in
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