import java.util.*;

public class B_Alternating_Series {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0)
                    a[i] = -1;
                else
                    a[i] = 3;
            }

            if (n % 2 == 0)
                a[n - 1] = 2;

            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }

            System.out.println();
        }
    }

    /*
     * sum +ve product -ve
     * 
     * -ve +ve -ve +ve
     * -1
     * a sub can have a +ve a + 1 neg -1 3 -1 3 -1 2
     */

}