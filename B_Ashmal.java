import java.io.*;
import java.util.*;

public class B_Ashmal {

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreElements())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String[] arr = new String[n];

            for (int i = 0; i < n; i++) {
                arr[i] = fs.next();
            }

            String s = "";

            for (int i = 0; i < n; i++) {
                String left = arr[i] + s;
                String right = s + arr[i];

                if (left.compareTo(right) <= 0) {
                    s = left;
                } else {
                    s = right;
                }
            }

            out.append(s).append('\n');
        }

        System.out.print(out.toString());
    }
}
