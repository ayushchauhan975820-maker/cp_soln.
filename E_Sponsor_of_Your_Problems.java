import java.util.*;

public class E_Sponsor_of_Your_Problems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            int n = a.length();
            if (a.equals(b)) {
                System.out.println(2 * n);
                continue;
            }

            int dp[][][] = new int[a.length()][2][2];
            for (int i = 0; i < a.length(); i++) {
                for (int j = 0; j < 2; j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }

            int ans = dfs(a, b, true, true, 0, dp);
            System.out.println(ans);
        }
    }

    public static int dfs(String a, String b, boolean lb, boolean ub, int n, int dp[][][]) {
        if (n == a.length()) {
            return 0;
        }

        if (dp[n][lb ? 1 : 0][ub ? 1 : 0] != -1)
            return dp[n][lb ? 1 : 0][ub ? 1 : 0];

        int low = lb ? a.charAt(n) : '0';
        int high = ub ? b.charAt(n) : '9';

        int contr = Integer.MAX_VALUE;
        for (int i = low; i <= high; i++) {
            int thisc = ((a.charAt(n) == i) ? 1 : 0) + ((b.charAt(n) == i) ? 1 : 0);
            boolean nlb = lb && (a.charAt(n) == i);
            boolean nub = ub && (b.charAt(n) == i);
            contr = Math.min(contr, thisc + dfs(a, b, nlb, nub, n + 1, dp));
        }

        return dp[n][lb ? 1 : 0][ub ? 1 : 0] = contr;
    }

    /*
     * 199
     * 201
     * 199
     * 
     */

}