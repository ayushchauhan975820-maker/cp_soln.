import java.util.*;

public class C_1_Hacking_Numbers_Easy_Version {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();

            for (int i = 0; i < 2; i++) {
                System.out.println("digit");
                System.out.flush();
                int x = sc.nextInt();
            }
            int a[] = { -8, -4, -2, -1 };
            for (int i = 0; i < 4; i++) {
                System.out.println("add " + a[i]);
                System.out.flush();
                int x = sc.nextInt();
            }

            long val = n - 1;
            System.out.println("add " + (val));
            System.out.flush();
            int x = sc.nextInt();
            System.out.println("!");
            System.out.flush();
            x = sc.nextInt();
        }
    }

    /*
     * 7
     * 
     * x -> S(x) ->
     * 
     * 
     * 15 - 8 0 1
     * 1 - 7
     * 1 - 3
     * 
     */

}