import java.util.*;

public class C_Inhabitant_of_the_Deep_Sea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long sum = 0;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

                sum += a[i];
            }

            if (sum <= k) {
                System.out.println(n);
                continue;
            }

            int count = 0;
            long ff = (k + 1) / 2;
            long fl = k - ff;

            for (int i = 0; i < n; i++) {
                if (ff == 0)
                    break;
                int val = a[i];
                if (ff >= val) {
                    count++;
                    a[i] = 0;
                    ff = ff - val;
                } else {
                    a[i] = (int) (val - ff);
                    ff = 0;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (fl == 0)
                    break;
                int val = a[j];
                if (val == 0)
                    break;

                if (fl >= val) {
                    count++;
                    a[j] = 0;
                    fl = fl - val;
                } else {
                    a[j] = (int) (val - fl);
                    fl = 0;
                }
            }

            System.out.println(count);
        }
    }

    /*
     * k -> f then l
     * if k is odd then it will be k/2 + 1 and k/2 else k/2 and k/2
     */

}