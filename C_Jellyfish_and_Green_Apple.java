import java.util.*;

public class C_Jellyfish_and_Green_Apple {
    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    public static int popcount(long x) {
        return Long.bitCount(x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            n %= m;

            long g = gcd(n, m);
            long a = n / g;
            long b = m / g;

            if (((b) & (b - 1)) != 0) {
                System.out.println(-1);
                continue;
            }

            long ans = 0;
            while (n != 0) {
                ans += n;

                n = (2L * n) % m;
            }

            System.out.println(ans);

            // if (popcount(b) > 1)
            // System.out.println(-1);
            // else
            // System.out.println((long) popcount(a) * m - n);
        }
    }

    /*
     * 1
     * .5 .5 1
     * .25 .25 .25 .25 2 -> 3
     * .125 .125 .125 .125 .125 .125 .125 .125 4 -> 7
     * 8 -> 15
     */

}