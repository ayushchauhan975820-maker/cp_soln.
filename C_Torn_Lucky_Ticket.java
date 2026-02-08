import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class C_Torn_Lucky_Ticket {
    public static class data {
        String num;
        int sum[];

        public data(String num, int sum[]) {
            this.num = num;
            this.sum = sum;
        }
    }

    public static void main(String[] args) throws java.io.IOException {
        FastReader sc = new FastReader();

        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        ArrayList<data> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String val = sc.next();
            int[] arr = new int[val.length()];
            for (int j = 0; j < val.length(); j++) {
                int dig = val.charAt(j) - '0';
                arr[j] = (j == 0) ? dig : dig + arr[j - 1];
            }
            list.add(new data(val, arr));
        }
        long count = 0;
        for (int i = 0; i < n; i++) {
            data cur = list.get(i);
            String c = cur.num;
            for (int j = i; j < n; j++) {
                data neigh = list.get(j);
                String neg = neigh.num;

                if ((neg.length() % 2 == 0 && c.length() % 2 == 0) || (neg.length() % 2 != 0 && c.length() % 2 != 0)) {
                    // first half
                    int t = c.length() + neg.length();
                    int si = t / 2;

                    if (c.length() == neg.length()) {
                        if (cur.sum[c.length() - 1] == neigh.sum[neg.length() - 1]) {
                            if (i == j)
                                count++;
                            else
                                count += 2;
                        }
                    } else if (c.length() > neg.length()) {
                        if (si > 0 && si <= c.length()) {
                            int sf = cur.sum[si - 1];
                            int ss = cur.sum[c.length() - 1] - sf + neigh.sum[neg.length() - 1];
                            if (sf == ss) {
                                if (i == j)
                                    count++;
                                else
                                    count += 2;
                            }
                        }
                    } else {
                        int k = si - c.length();

                        int prefix_index = k - 1;

                        int sf = cur.sum[c.length() - 1] + neigh.sum[prefix_index];
                        int ss = neigh.sum[neg.length() - 1] - neigh.sum[prefix_index];

                        if (sf == ss) {
                            if (i == j)
                                count++;
                            else
                                count += 2;
                        }
                    }
                }
            }
        }

        out.println(count);

        out.close();
    }

    /*
     * b is given
     * 
     * find if in k ops you can obtain a
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