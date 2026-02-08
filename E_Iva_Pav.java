import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class E_Iva_Pav {
    public static void main(String[] args) throws java.io.IOException {
        FastReader sc = new FastReader();

        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int pre[][] = new int[32][n];
            for (int i = 0; i < 31; i++) {
                for (int j = 0; j < n; j++) {
                    int set = ((a[j] & (1 << i)) != 0) ? 1 : 0;
                    pre[i][j] = (j == 0) ? set : pre[i][j - 1] + set;
                }
            }

            int q = sc.nextInt();

            for (int i = 0; i < q; i++) {
                int l = sc.nextInt() - 1;
                int k = sc.nextInt();
                int ans = -1;
                int s = l;
                int e = n - 1;
                while (s <= e) {
                    int mid = s + (e - s) / 2;

                    int and = 0;
                    for (int j = 0; j < 31; j++) {
                        int left = (l == 0) ? 0 : pre[j][l - 1];
                        int right = pre[j][mid];

                        if (right - left == mid - l + 1) {
                            and = and + (1 << j);
                        }
                    }

                    if (and >= k) {
                        ans = mid + 1;
                        s = mid + 1;
                    } else {
                        e = mid - 1;
                    }
                }
                out.print(ans + " ");
            }
            out.println();
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