import java.util.*;

public class A_Fill_in_the_Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int grid[][] = new int[n][m];

            for (int j = 0; j < m; j++) {
                int num = 0;
                for (int i = 0; i < n; i++) {
                    if (num == j)
                        num++;

                    grid[i][j] = num++;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    /*
     * every row must be a permutation
     * 
     * vi = mex of ith col
     * 
     * M = mex of all vi
     * 
     * 0 should not be if 1 col start from second row
     */

}