import java.util.*;

public class B_Yuu_Koito_and_Minimum_Absolute_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (i != 0 && i != n - 1) {
                    if (a[i] == -1) {
                        b[i] = 0;
                    } else {
                        b[i] = a[i];
                    }
                } else {
                    b[i] = a[i];
                }
            }

            if (a[0] == -1 && a[n - 1] == -1) {
                b[0] = 0;
                b[n - 1] = 0;
            } else if (a[0] == -1) {
                b[0] = a[n - 1];
            } else if (a[n - 1] == -1) {
                b[n - 1] = a[0];
            }

            int diff = 0;
            for (int i = 1; i < n; i++) {
                diff += b[i] - b[i - 1];
            }

            System.out.println(Math.abs(diff));
            for (int i = 0; i < n; i++) {
                System.out.print(b[i] + " ");
            }
            System.out.println();
        }
    }

    /*
        
    */

}