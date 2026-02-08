import java.util.*;

public class C_2_Renako_Amaori_and_XOR_Game_hard_version {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            int pre[][] = new int[21][n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 20; j >= 0; j--) {
                    boolean f = (a[i] & (1 << j)) != 0;
                    boolean s = (b[i] & (1 << j)) != 0;

                    int prev = (i == 0 ? 0 : pre[j][i - 1]);
                    int contribution = 0;

                    if (f != s) {
                        contribution = ((i + 1) % 2 != 0) ? 1 : -1;
                    }

                    pre[j][i] = prev + contribution;
                }
            }

            boolean found = false;
            for (int j = 20; j >= 0; j--) {
                for (int i = n - 1; i >= 0; i--) {
                    boolean f = (a[i] & (1 << j)) != 0;
                    boolean s = (b[i] & (1 << j)) != 0;
                    if (f != s) {
                        found = true;
                        if (Math.abs(pre[j][i]) % 2 != 0) {
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
                if (found)
                    break;
            }
            if (!found)
                System.out.println("Tie");
        }
    }

    /*
        
    */

}