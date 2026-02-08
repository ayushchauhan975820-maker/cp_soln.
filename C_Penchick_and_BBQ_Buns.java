import java.util.*;

public class C_Penchick_and_BBQ_Buns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int a[] = new int[n];
            if (n < 27 && n % 2 != 0) {
                System.out.println(-1);
                continue;
            }
            if (n % 2 == 0) {
                int val = 1;
                for (int i = 1; i < n; i += 2) {
                    a[i - 1] = val;
                    a[i] = val;
                    val++;
                }
            } else {
                a[0] = 1;
                a[9] = 1;
                a[25] = 1;

                a[22] = 2;
                a[26] = 2;
                int val = 3;
                for (int i = 2; i <= 8; i += 2) {
                    a[i] = val;
                    a[i - 1] = val;
                    val++;
                }

                for (int i = 11; i <= 21; i += 2) {
                    a[i] = val;
                    a[i - 1] = val;
                    val++;
                }

                a[23] = val;
                a[24] = val;
                val++;

                for (int i = 28; i < n; i += 2) {
                    a[i] = val;
                    a[i - 1] = val;
                    val++;
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }

            System.out.println();
        }
    }

    /*
        
    */

}
