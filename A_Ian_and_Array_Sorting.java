import java.util.*;

public class A_Ian_and_Array_Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            if (n % 2 != 0) {
                System.out.println("YES");
                continue;
            }

            for (int i = 1; i < n - 1; i++) {

                long diff = a[i] - a[i - 1];

                a[i + 1] -= diff;
                a[i] = a[i - 1];

            }

            if (a[n - 1] >= a[n - 2])
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    /*
     * a b c d e
     * a <= b <= c <= d <= e
     * +1 +1 or -1 -1 ops make diff invarient but doing op on side can change it
     * 
     * 2 1 4 3
     * -1 3 1
     * 
     * 
     * 
     * 1 1 2 2 3 3 4 4 10 10 20
     * 0 1 0 1 0 1 0 6 0 10
     */
}