import java.util.*;

public class B_Binary_Path {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String r1 = sc.next();
            String r2 = sc.next();

            StringBuilder sb = new StringBuilder();
            int st = 1;
            for (int i = 0; i < n; i++) {
                char c1 = r1.charAt(i);
                char c2 = r2.charAt(i);

                if (st == 1) {
                    if (c1 == c2 || c1 == '0')
                        sb.append(c1);
                    else {
                        if (i == 0) {
                            sb.append(c1);
                        } else {
                            char last = r2.charAt(i - 1);
                            if (last == '0') {
                                sb.append(0);
                            } else {
                                sb.append(1);
                            }
                        }
                        st = 2;
                        sb.append(c2);
                    }
                } else {
                    sb.append(c2);
                }
            }
            if (sb.length() < n + 1)
                sb.append(r2.charAt(n - 1));

            String ans = sb.toString();
            int dp[][][] = new int[n + 1][2][n];
            for (int i = 0; i < 2; i++) {
                for (int idx = 0; idx < n + 1; idx++) {
                    for (int j = 0; j < n; j++) {
                        dp[idx][i][j] = -1;
                    }
                }
            }
            int count = count(ans, r1, r2, n, 1, n - 1, dp);

            System.out.println(ans);
            System.out.println(count);
        }
    }

    public static int count(String ans, String r1, String r2, int idx, int i, int j, int dp[][][]) {
        if (j < 0 || idx < 0)
            return 0;
        if (idx == 0 && i == 0 && j == 0)
            return 1;

        if (dp[idx][i][j] != -1)
            return dp[idx][i][j];

        int a = 0;
        if (i == 0) {
            if (ans.charAt(idx) == r1.charAt(j)) {
                a = count(ans, r1, r2, idx - 1, i, j - 1, dp);
            }
        } else {
            if (ans.charAt(idx) == r2.charAt(j)) {
                int ahead = count(ans, r1, r2, idx - 1, i, j - 1, dp);
                int top = count(ans, r1, r2, idx - 1, 0, j, dp);

                a = ahead + top;
            }
        }

        return dp[idx][i][j] = a;
    }

    /*
     * // pick 0 as much as we can
     */

}