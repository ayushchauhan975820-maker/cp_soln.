import java.util.*;

public class G_Sakura_Adachi_and_Optimal_Sequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            long mod = (long) (1e6 + 3);
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                b[i] = sc.nextInt();

            int max = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (b[i] < a[i]) {
                    max = 0;
                } else {
                    long ratio = b[i] / a[i];
                    int k = 63 - Long.numberOfLeadingZeros(ratio);
                    max = Math.min(max, k);
                }
            }

            long x = max;
            for (int i = 0; i < n; i++) {
                long left = b[i] - a[i] * (1L << max);
                x += left;
            }

            System.out.println(x);
        }
    }

    /*
     * a * 2^x < b
     * 2^x < b/a
     * x < log(b/a)
     */

}