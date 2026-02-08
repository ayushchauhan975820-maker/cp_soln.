import java.util.*;

public class B_Make_Connected {
    public static void dfs(char grid[][], int i, int j, int d) {
        int n = grid.length;
        if (d == 0) {
            // right up
            int r = i;
            int c = j;
            while (isValid(n, r, c)) {
                grid[r][c] = '.';
                r--;
                c++;
            }

            // left down
            r = i;
            c = j;
            while (isValid(n, r, c)) {
                grid[r][c] = '.';
                r++;
                c--;
            }
        } else {
            // left up
            int r = i;
            int c = j;
            while (isValid(n, r, c)) {
                grid[r][c] = '.';
                r--;
                c--;
            }

            // right down
            r = i;
            c = j;
            while (isValid(n, r, c)) {
                grid[r][c] = '.';
                r++;
                c++;
            }
        }

    }

    public static boolean isValid(int n, int i, int j) {
        return (i >= 0 && j >= 0 && i < n && j < n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            char grid[][] = new char[n][n];
            char dup[][] = new char[n][n];
            for (int i = 0; i < n; i++) {
                grid[i] = sc.next().toCharArray();
            }
            dup = grid;
            // already invalid
            boolean valid = true;
            int r = 0;
            int c = 0;
            for (int i = 0; i < n; i++) {
                boolean broken = false;
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '#') {
                        r = i;
                        c = j;
                        boolean ra = false;
                        boolean rb = false;
                        boolean ca = false;
                        boolean cb = false;

                        if (j > 0 && grid[i][j - 1] == '#')
                            rb = true;
                        if (j < n - 1 && grid[i][j + 1] == '#')
                            ra = true;

                        if (i > 0 && grid[i - 1][j] == '#')
                            cb = true;
                        if (i < n - 1 && grid[i + 1][j] == '#')
                            ca = true;

                        if ((rb && ra) || (ca && cb)) {
                            broken = true;
                            break;
                        }
                    }
                }
                if (broken) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                System.out.println("NO");
                continue;
            }

            // check for connections . find one
            boolean iscorner = ((r == 0 && c == 0) || (r == 0 && c == n - 1) || (c == 0 || r == n - 1)
                    || (c == n - 1 && r == n - 1));
            boolean cel = (r == 0 || r == n - 1);
            boolean left = false;
            boolean right = false;
            if (iscorner) {
                dfs(grid, r, c, 0);
                if ((r == 0 && c == 0)) {
                    dfs(grid, r + 1, c, 0);
                    dfs(grid, r, c + 1, 0);
                } else if ((r == n - 1 && c == n - 1)) {
                    dfs(grid, r - 1, c, 0);
                    dfs(grid, r, c - 1, 0);
                } else if (r == 0) {
                    dfs(grid, r + 1, c, 0);
                    dfs(grid, r, c - 1, 0);
                } else {
                    dfs(grid, r - 1, c, 0);
                    dfs(grid, r, c + 1, 0);
                }
            } else if (cel) {
                dfs(grid, r, c, 0);
                dfs(grid, r - 1, c, 0);
                dfs(grid, r + 1, c, 0);
            } else {
                dfs(grid, r, c, 0);
                dfs(grid, r, c - 1, 0);
                dfs(grid, r, c + 1, 0);
            }
            grid = dup;
            for (int i = 0; i < n; i++) {
                boolean broken = false;
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '#') {
                        broken = true;
                        break;
                    }
                }
                if (broken) {
                    left = false;
                    break;
                }
            }

            if (iscorner) {
                dfs(grid, r, c, 1);
                if ((r == 0 && c == 0)) {
                    dfs(grid, r + 1, c, 1);
                    dfs(grid, r, c + 1, 1);
                } else if ((r == n - 1 && c == n - 1)) {
                    dfs(grid, r - 1, c, 1);
                    dfs(grid, r, c - 1, 1);
                } else if (r == 0) {
                    dfs(grid, r + 1, c, 1);
                    dfs(grid, r, c - 1, 1);
                } else {
                    dfs(grid, r - 1, c, 1);
                    dfs(grid, r, c + 1, 1);
                }
            } else if (cel) {
                dfs(grid, r, c, 1);
                dfs(grid, r - 1, c, 1);
                dfs(grid, r + 1, c, 1);
            } else {
                dfs(grid, r, c, 1);
                dfs(grid, r, c - 1, 1);
                dfs(grid, r, c + 1, 1);
            }

            for (int i = 0; i < n; i++) {
                boolean broken = false;
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '#') {
                        broken = true;
                        break;
                    }
                }
                if (broken) {
                    right = false;
                    break;
                }
            }

            if (left || right)
                valid = true;

            if (!valid)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }

    /*
        
    */

}