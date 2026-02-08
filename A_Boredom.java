import java.util.*;

public class A_Boredom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        TreeMap<Integer, Long> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0L) + a[i]);
        }

        int b[] = new int[map.size()];
        int id = 0;
        for (int key : map.keySet()) {
            b[id++] = key;
        }

        long dp[][] = new long[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {

            }
        }
        long ans = dfs(b, map, 0, 0, dp);
        System.out.println(ans);
    }

    public static long dfs(int b[], TreeMap<Integer, Long> map, int i, int j, long dp[][]) {
        if (i == b.length)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (j == 0) {
            long skip = dfs(b, map, i + 1, 0, dp);
            long pick = dfs(b, map, i + 1, 1, dp) + map.get(b[i]);

            return dp[i][j] = Math.max(skip, pick);
        } else {
            if (b[i - 1] + 1 == b[i]) {
                return dp[i][j] = dfs(b, map, i + 1, 0, dp);
            } else {
                long skip = dfs(b, map, i + 1, 0, dp);
                long pick = dfs(b, map, i + 1, 1, dp) + map.get(b[i]);

                return dp[i][j] = Math.max(skip, pick);
            }
        }
    }
}

/*
 * 
 * del ak and ak+1 ak-1 -> ak
 * max sum of non alternative seq
 * 
 * f(i, j) -> contribution of ith idx such that jth is picked
 * dp[]
 */