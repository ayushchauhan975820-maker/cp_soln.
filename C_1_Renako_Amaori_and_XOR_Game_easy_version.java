import java.util.*;

public class C_1_Renako_Amaori_and_XOR_Game_easy_version {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            int pre[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                int prev = (i == 0 ? 0 : pre[i - 1]);
                int contribution = 0;

                if (a[i] != b[i]) {
                    contribution = ((i + 1) % 2 != 0) ? 1 : -1;
                }

                pre[i] = prev + contribution;
            }

            boolean found = false;
            for (int i = n - 1; i >= 0; i--) {
                if (a[i] != b[i]) {
                    found = true;
                    if (Math.abs(pre[i]) % 2 != 0) {
                        if (i % 2 == 0)
                            System.out.println("Ajisai");
                        else
                            System.out.println("Mai");
                    } else {
                        found = false;
                    }
                    break;
                }
            }
            if (!found)
                System.out.println("Tie");
        }
    }

    /*
        
    */

}