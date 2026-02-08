import java.util.*;

public class A_Swap_Columns_and_Find_a_Path {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] path = new int[2][n];

            for (int i = 0; i < n; i++) {
                path[0][i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                path[1][i] = sc.nextInt();
            }
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (long) Math.max(path[0][i], path[1][i]);
            }

            long max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                long val = sum + (long) Math.min(path[0][i], path[1][i]);
                max = Math.max(max, val);
            }

            System.out.println(max);
        }
    }
}