import java.util.*;

public class D_Absolute_Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            long sum = 0;
            boolean isInc = true;
            boolean isDec = true;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                sum += (long) a[i];
                if (i > 0) {
                    if (a[i - 1] > a[i]) {
                        isInc = false;
                    }
                    if (a[i] > a[i - 1]) {
                        isDec = false;
                    }
                }
            }

            long low = 0;
            long high = (int) (1e9);

            for (int i = 1; i < n; i++) {
                long l = ((long) a[i] + a[i - 1]) / 2;
                long h = ((long) a[i] + a[i - 1] + 1) / 2;

                if (a[i] > a[i - 1]) {
                    high = Math.min(high, l);
                }
                if (a[i] < a[i - 1]) {
                    low = Math.max(low, h);
                }
            }

            if (low <= high)
                System.out.println(low);
            else
                System.out.println(-1);
        }
    }

    /*
        
    */

}