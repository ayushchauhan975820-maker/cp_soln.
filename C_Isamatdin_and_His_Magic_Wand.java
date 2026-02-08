import java.util.*;

public class C_Isamatdin_and_His_Magic_Wand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int ec = 0;
            int oc = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

                if (a[i] % 2 == 0)
                    ec++;
                else
                    oc++;
            }

            if (ec == 0 || oc == 0) {
                for (int i = 0; i < n; i++) {
                    System.out.print(a[i] + " ");
                }
                System.out.println();
                continue;
            }

            Arrays.sort(a);
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();

        }
    }

    /*
     * can always swap if even a single odd exist
     */

}