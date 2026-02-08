import java.awt.List;
import java.util.*;

public class C_Remove_the_Ends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            long prefix[] = new long[n];
            long suffix[] = new long[n];

            for (int i = 0; i < n; i++) {
                if (a[i] > 0) {
                    prefix[i] = (i == 0) ? a[i] : prefix[i - 1] + a[i];
                    suffix[i] = (i == 0) ? 0 : suffix[i - 1];
                } else {
                    prefix[i] = (i == 0) ? 0 : prefix[i - 1];
                    suffix[i] = (i == 0) ? -a[i] : suffix[i - 1] - a[i];
                }
            }

            long ans = Math.max(prefix[n - 1], suffix[n - 1]);
            // sum of upto i and rest negative
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, prefix[i] + suffix[n - 1] - suffix[i]);
            }

            System.out.println(ans);
        }
    }

    /*
        
    */

}