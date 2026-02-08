import java.util.*;

public class D_Two_Colored_Dominoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char grid[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                grid[i] = sc.next().toCharArray();
            }

            boolean odd = false;

            // coloring
            int row[] = new int[n];
            int col[] = new int[m];
            int vis[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 'L') {
                        col[j]++;
                    }

                    if (grid[i][j] == 'U') {
                        row[i]++;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (row[i] % 2 != 0) {
                    odd = true;
                    break;
                }
            }
            for (int j = 0; j < m; j++) {
                if (col[j] % 2 != 0) {
                    odd = true;
                    break;
                }
            }
            if (odd) {
                System.out.println(-1);
                continue;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 'L') {
                        if (col[j] % 2 == 0) {
                            // paint white
                            vis[i][j] = 1;
                            vis[i][j + 1] = 2;
                            col[j]--;
                        } else {
                            // paint black
                            vis[i][j + 1] = 1;
                            vis[i][j] = 2;
                            col[j]--;
                        }
                    }
                    if (grid[i][j] == 'U') {
                        if (row[i] % 2 == 0) {
                            // paint white
                            vis[i][j] = 1;
                            vis[i + 1][j] = 2;
                            row[i]--;
                        } else {
                            // paint black
                            vis[i + 1][j] = 1;
                            vis[i][j] = 2;
                            row[i]--;
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(vis[i][j] == 0 ? '.' : vis[i][j] == 1 ? 'W' : 'B');
                }
                System.out.println();
            }
        }
    }

    /*
     * add top + elft - diagonal
     * 
     * // int suff[][] = new int[n][m];
     * // for (int i = 0; i < n; i++) {
     * // for (int j = 0; j < m; j++) {
     * // int top = (i == 0) ? 0 : suff[i - 1][j];
     * // int left = (j == 0) ? 0 : suff[i][j - 1];
     * // int diag = (i == 0 || j == 0) ? 0 : suff[i - 1][j - 1];
     * // int val = (grid[i][j] == '.') ? 0 : 1;
     * // suff[i][j] = top + left - diag + val;
     * // }
     * // }
     * 
     * // // check if it contains odd in any
     * boolean odd = false;
     * // for (int i = 0; i < n; i++) {
     * // int top = (i == 0) ? 0 : suff[i - 1][m - 1];
     * // int el = suff[i][m - 1] - top;
     * 
     * // if (el % 2 != 0) {
     * // odd = true;
     * // break;
     * // }
     * // }
     * // for (int i = 0; i < m; i++) {
     * // int left = (i == 0) ? 0 : suff[n - 1][i - 1];
     * // int el = suff[n - 1][i] - left;
     * // if (el % 2 != 0) {
     * // odd = true;
     * // break;
     * // }
     * // }
     * // if (odd) {
     * // System.out.println(-1);
     * // continue;
     * // }
     */

}