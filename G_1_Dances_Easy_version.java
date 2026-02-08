import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;
import java.util.StringTokenizer;

public class G_1_Dances_Easy_version {
    public static void main(String[] args) throws java.io.IOException {
        FastReader sc = new FastReader();

        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            a.add(1);
            for (int i = 0; i < n - 1; i++) {
                int val = sc.nextInt();
                a.add(val);
            }
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                b.add(val);
            }
            Collections.sort(a);
            Collections.sort(b);
            int s = 0;
            int count = 0;
            int l = 0;
            int r = n - 1;
            while (s < n && l < n) {
                if (a.get(s) >= b.get(l)) {
                    count++;
                    r--;
                    l++;
                } else {
                    s++;
                    l++;
                }
            }

            out.println(count);
        }

        out.close();
    }

    /*
     * choose an element in a and b and remove from both
     * 
     * remove small from b and big from a
     * 
     * 1 2 3 4 5 6 7 8 9
     * 1 1 2 2 3 4 5 5 6
     * 
     * 
     * 1 2 3 4 5
     * 2 3 4 5 6
     */

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