import java.util.*;

public class B_250_Thousand_Tons_of_TNT {
    public static long getDiff(long prefix[], int n, int k) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        long pre = 0;
        for (int j = k - 1; j < n; j = j + k) {
            long sum = prefix[j] - pre;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            pre = prefix[j];
        }

        return min == Long.MAX_VALUE ? 0 : Math.abs(max - min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            long arr[] = new long[n];
            long prefix[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();

                if (i == 0)
                    prefix[i] = arr[i];
                else
                    prefix[i] = prefix[i - 1] + arr[i];
            }

            if (n == 0) {
                System.out.println(1);
                continue;
            }
            long ans = 0;
            for (int i = 1; i * i <= n; i++) {
                if (n % i != 0)
                    continue;

                ans = Math.max(ans, getDiff(prefix, n, i));

                if (i != n / i)
                    ans = Math.max(ans, getDiff(prefix, n, n / i));
            }

            System.out.println(ans);
        }
    }
}