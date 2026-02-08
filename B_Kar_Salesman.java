import java.io.*;
import java.util.*;

public class B_Kar_Salesman {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long sum = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                int val = Integer.parseInt(st.nextToken());
                sum += val;
                if (val > max)
                    max = val;
            }
            long ans = Math.max(max, (sum + x - 1) / x);
            out.append(ans).append('\n');
        }
        System.out.print(out);
    }
}