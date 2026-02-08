import java.util.*;

public class C_Blackslex_and_Number_Theory {
    public static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            long r = 0;
            long min = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                min = Math.min(min, a[i]);
                r = Math.max(r, a[i]);
            }

            long l = min;
            long ans = min;
            while (l <= r) {
                long mid = l + (r - l) / 2;
                if (isValid(a, mid, min)) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            System.out.println(ans);
        }
    }

    public static boolean isValid(long a[], long k, long min) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] != min) {
                if (a[i] - min < k) {
                    return false;
                }
            }
        }

        return true;
    }
    /*
        
    */

}