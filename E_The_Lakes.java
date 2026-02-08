import java.util.*;

public class E_The_Lakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] grid = new int[n][m];
            boolean vis[][] = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            int max = 0;
            int mov[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
            Queue<Integer[]> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int sum = 0;
                    if (!vis[i][j] && grid[i][j] > 0) {
                        q.offer(new Integer[] { i, j });
                        vis[i][j] = true;
                        sum += grid[i][j];
                        while (!q.isEmpty()) {
                            Integer[] cur = q.poll();
                            int row = cur[0];
                            int col = cur[1];

                            for (int k = 0; k < 4; k++) {
                                int nr = row + mov[k][0];
                                int nc = col + mov[k][1];

                                if (nr >= 0 && nc >= 0 && nr < n && nc < m && !vis[nr][nc] && grid[nr][nc] > 0) {
                                    q.add(new Integer[] { nr, nc });
                                    vis[nr][nc] = true;
                                    sum += grid[nr][nc];
                                }
                            }
                        }
                    }

                    max = Math.max(max, sum);
                }
            }

            System.out.println(max);
        }
    }
}