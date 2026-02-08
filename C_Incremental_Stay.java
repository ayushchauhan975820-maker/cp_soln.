import java.util.*;

public class C_Incremental_Stay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long arr[] = new long[2 * n];
            long pref[] = new long[2 * n];
            long alter[] = new long[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                arr[i] = sc.nextLong();

                if (i == 0)
                    pref[i] = arr[i];
                else
                    pref[i] = pref[i - 1] + arr[i];

                if (i == 0 || i == 1)
                    alter[i] = arr[i];
                else
                    alter[i] = alter[i - 2] + arr[i];
            }
            long ans[] = new long[n];
            for (int k = 1; k <= n; k++) {
                // add first k
                long stSum = pref[k - 1];
                // add alternates
                long alterSum = 0;
                if (2 * n - k - 1 >= k - 1)
                    alterSum = alter[2 * n - k - 1] - alter[k - 1];

                ans[k - 1] = pref[2 * n - 1] - 2 * (stSum + alterSum);
            }

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}