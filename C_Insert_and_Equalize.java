import java.util.*;

public class C_Insert_and_Equalize {
    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            HashSet<Long> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                set.add(a[i]);
            }
            Arrays.sort(a);
            long gcd = 0;
            if (n == 1)
                gcd = 1;
            else {
                for (int i = 1; i < n; i++) {
                    gcd = gcd(gcd, a[i] - a[i - 1]);
                }
            }

            long val = a[n - 1];
            for (int i = 0; i < n; i++) {
                val -= gcd;

                if (!set.contains(val)) {
                    break;
                }
            }

            long ops = (a[n - 1] - val) / gcd;
            for (int i = 0; i < n; i++) {
                long diff = a[n - 1] - a[i];
                long toAdd = diff / gcd;

                ops += toAdd;
            }

            System.out.println(ops);
        }
    }
    /*
     * 1 -19 17 -3 -15
     * -19 -15 -3 1 17 13
     * 4 12 4 16 (gcd - 4)
     * 
     * try to find the number so that it can complete the gcd if there is any break
     * lets prove
     * 
     * a1 a2 a3 a5 a4
     * d1 d2 d4 d3
     * x greater than 1
     * (a3 - a5, a5 - a4)
     * 
     * if(diff is odd then no middle can exist) else sum/2 so that gcd can be 2 if
     * all satisfy
     * find any middle no whose gcd is not in the array
     */
}