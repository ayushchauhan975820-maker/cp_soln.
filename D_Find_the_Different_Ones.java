import java.util.*;

public class D_Find_the_Different_Ones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int[] cls = new int[n];
            for (int i = 0; i < n; i++) {
                if (i > 0 && a[i - 1] == a[i]) {
                    cls[i] = cls[i - 1];
                    continue;
                }

                int idx = i + 1;
                while (idx < n && a[idx] == a[i]) {
                    idx++;
                }

                cls[i] = idx;
            }

            int q = sc.nextInt();
            for (int i = 0; i < q; i++) {
                int l = sc.nextInt() - 1;
                int r = sc.nextInt() - 1;

                int near = cls[l];
                if (near > r)
                    System.out.println(-1 + " " + -1);
                else
                    System.out.println((l + 1) + " " + (near + 1));
            }

            System.out.println();
        }
    }

    /*
     * only case it will not exist if all are same -> al - ar are equal elements
     * 
     * find closest for l if its in range then ans pos otherwise not
     */

}