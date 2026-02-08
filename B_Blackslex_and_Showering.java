import java.util.*;

public class B_Blackslex_and_Showering {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            long tot = 0;
            for (int i = 1; i < n; i++) {
                tot += Math.abs(a[i] - a[i - 1]);
            }

            long ans = tot;

            for (int i = 0; i < n; i++) {
                long cur = tot;

                if (i > 0) {
                    cur -= Math.abs(a[i] - a[i - 1]);
                }
                if (i < n - 1) {
                    cur -= Math.abs(a[i + 1] - a[i]);
                }
                if (i > 0 && i < n - 1) {
                    cur += Math.abs(a[i + 1] - a[i - 1]);
                }

                ans = Math.min(ans, cur);
            }

            System.out.println(ans);
        }
        sc.close();
    }
}
