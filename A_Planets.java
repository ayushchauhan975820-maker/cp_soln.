import java.util.*;

public class A_Planets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int c = sc.nextInt();

            int a[] = new int[101];
            for (int i = 0; i < n; i++) {
                int p = sc.nextInt();
                a[p]++;
            }

            int tot = 0;
            for (int i = 0; i < 101; i++) {
                tot += Math.min(a[i], c);
            }

            System.out.println(tot);
        }
    }

    /*
        
    */

}