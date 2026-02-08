import java.util.*;

public class C_Arrow_Path {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String r1 = sc.next();
            String r2 = sc.next();

            boolean vis[][] = new boolean[2][n];
            dfs(n, r1, r2, vis, 0, 0);

            System.out.println((vis[1][n - 1]) ? "YES" : "NO");
        }
    }

    public static void dfs(int n, String s1, String s2, boolean vis[][], int i, int j) {
        if (i < 0 || j < 0 || i >= 2 || j >= n) {
            return;
        }
        if (vis[i][j] == true)
            return;

        vis[i][j] = true;

        int move[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        for (int k = 0; k < 4; k++) {
            int nr = i + move[k][0];
            int nc = j + move[k][1];

            if (nr >= 0 && nc >= 0 && nr < 2 && nc < n) {
                if (nr == 0) {
                    if (s1.charAt(nc) == '>') {
                        dfs(n, s1, s2, vis, nr, nc + 1);
                    } else {
                        dfs(n, s1, s2, vis, nr, nc - 1);
                    }
                } else {
                    if (s2.charAt(nc) == '>') {
                        dfs(n, s1, s2, vis, nr, nc + 1);
                    } else {
                        dfs(n, s1, s2, vis, nr, nc - 1);
                    }
                }
            }
        }

        return;
    }

    /*
        
    */

}