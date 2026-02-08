import java.util.*;

public class D_Seraphim_the_Owl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            long minCost = Long.MAX_VALUE;
            int[] a = new int[n];
            int[] b = new int[n];
            long suffix[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            for (int i = n - 1; i >= 0; i--) {
                if (i == n - 1)
                    suffix[i] = b[i];
                else
                    suffix[i] = suffix[i + 1] + b[i];
            }

            long dp[] = new long[n];
            // for (int i = n - 1; i >= 0; i--) {
            // // either jump dirctly or calc from last

            // // jump
            // long jump = (i == n - 1) ? 0 : suffix[i + 1];

            // // calc from last
            // long last = (i == n - 1) ? 0 : dp[i + 1];

            // dp[i] = Math.min(jump, last) + (long) a[i];
            // }

            long min = (long) (1e12);
            int idx = n;
            for (int i = n - 1; i >= 0; i--) {
                // jump
                long jump = (i == n - 1) ? 0 : suffix[i + 1];

                // jump to min then to next min
                long fromMin = (long) (1e12);
                if (min != (long) (1e12)) {
                    // from j to idx
                    fromMin = suffix[i + 1] - suffix[idx];
                }

                dp[i] = Math.min(jump, min + fromMin) + a[i];

                if (dp[i] <= min) {
                    min = dp[i];
                    idx = i;
                }
            }

            for (int i = 0; i < m; i++) {
                minCost = Math.min(minCost, dp[i]);
            }

            System.out.println(minCost);
        }
    }

    /*
        
    */

}