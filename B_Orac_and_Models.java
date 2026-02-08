import java.util.*;

public class B_Orac_and_Models {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int dp[] = new int[n + 1];
            int ans = 1;
            for (int i = 1; i <= n; i++) {
                int max = 1;
                for (int j = 1; j * j <= i; j++) {
                    if (i % j == 0) {
                        int d1 = j;
                        int d2 = i / j;

                        if (d1 < i && a[d1 - 1] < a[i - 1])
                            max = Math.max(max, dp[d1] + 1);

                        if (d2 != d1 && d2 < i && a[d2 - 1] < a[i - 1])
                            max = Math.max(max, dp[d2] + 1);
                    }
                }
                dp[i] = max;
                ans = Math.max(ans, max);
            }

            System.out.println(ans);
        }
    }

    /*
     * f(x) -> largest string upto x considering all the divisors
     */
}