import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class F_You_Are_So_Beautiful {
    public static void main(String[] args) throws java.io.IOException {
        FastReader sc = new FastReader();

        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                map.put(a[i], i);
            }

            int suff[] = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                int val = (map.containsKey(a[i]) && map.get(a[i]) == i) ? 1 : 0;
                suff[i] = (i == n - 1) ? val : suff[i + 1] + val;
            }

            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (!set.contains(a[i])) {
                    sum += (long) suff[i];
                    set.add(a[i]);
                }
            }

            out.println(sum);
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

/*
 * a b a c d a
 * 0 1 0 1 1 1
 * 
 * 4 5 4 5 4
 * 0 0 0 1 1
 * 2 2 2 1 1
 * 
 * 2 + 2
 * 
 * any idx can form subarray with all the element whose last pos is after it
 * 
 * so every letter can only form from first occurance of it and that is equal to
 * suffix sum util that
 * 
 * 
 */