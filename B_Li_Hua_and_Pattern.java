import java.io.*;
import java.util.*;

public class B_Li_Hua_and_Pattern {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ops = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (grid[i][j] != grid[n - 1 - i][n - 1 - j])
                        ops++;
            ops /= 2;

            if (ops > k)
                out.append("NO\n");
            else if ((k - ops) % 2 == 0 || n % 2 == 1)
                out.append("YES\n");
            else
                out.append("NO\n");
        }
        System.out.print(out);
    }
}