import java.util.*;

public class C_First_or_Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            long[] pref = new long[n];
            pref[0] = 0;
            for (int i = 1; i < n; i++) {
                pref[i] = pref[i - 1] + Math.abs(a[i]);
            }

            long[] suff = new long[n + 1];
            suff[n] = 0;
            for (int i = n - 1; i >= 0; i--) {
                suff[i] = suff[i + 1] - a[i];
            }

            long ans = Long.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                // skip
                long pre = (i == 0) ? 0 : pref[i - 1] + a[0];
                long suf = suff[i + 1];
                ans = Math.max(ans, pre + suf);
            }

            System.out.println(ans);
        }
    }

}