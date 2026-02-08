import java.util.*;

public class E_2_Rudolf_and_Snowflakes_hard_version {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            boolean found = false;

            for (int p = 2; p <= 63; p++) {
                long kl = 2L;
                long kh = (long) (1e18);
                boolean valid = false;

                while (kl <= kh) {
                    long mid = kl + (kh - kl) / 2;

                    long sum = 1 + mid + mid * mid;
                    long pre = mid * mid * mid;
                    for (int i = 3; i <= p && sum < n; i++) {
                        long newPre = mid * pre;
                        sum += pre;
                        pre = newPre;
                    }

                    if (sum == n) {
                        valid = true;
                        break;
                    } else if (sum > n) {
                        kh = mid - 1;
                    } else {
                        kl = mid + 1;
                    }
                }

                if (valid) {
                    found = true;
                    break;
                }
            }

            if (found)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}