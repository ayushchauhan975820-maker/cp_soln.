import java.util.*;

public class A_Gellyfish_and_Flaming_Peony {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int gcd = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                gcd = gcd(gcd, a[i]);
            }
            boolean cnts = false;
            int ct = 0;
            int dp[] = new int[5001];
            Arrays.fill(dp, Integer.MAX_VALUE);
            for (int i = 0; i < n; i++) {
                dp[a[i]] = 0;
                if (a[i] == gcd)
                    cnts = true;
                else
                    ct++;
            }

            if (cnts) {
                System.out.println(ct);
                continue;
            }

            Arrays.sort(a);

            for (int i = 5000; i >= 1; i--) {
                if (dp[i] == Integer.MAX_VALUE)
                    continue;

                for (int val : a) {
                    int gcdt = gcd(val, i);

                    dp[gcdt] = Math.min(dp[gcdt], dp[i] + 1);
                }
            }

            int answer = dp[gcd] + (ct - 1);
            System.out.println(answer);
        }
    }

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    /*
     * dp[i, val] =
     */

}