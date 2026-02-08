import java.util.*;

public class C_Quests {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long sum = 0;
            long max = 0;
            long inB = -1;

            int a[] = new int[n];
            int b[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            for (int i = 0; i < Math.min(n, k); i++) {
                sum += (long) a[i];
                inB = Math.max(inB, b[i]);

                long left = k - (i + 1);
                long lc = inB * left;

                max = Math.max(max, sum + lc);
            }

            System.out.println(max);
        }
    }
}