import java.util.*;

public class B_Digits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();

            System.out.print(1 + " ");

            // for 3
            if (n >= 3 || d % 3 == 0) {
                System.out.print(3 + " ");
            }

            // for 5
            if (d == 5) {
                System.out.print(5 + " ");
            }

            // for 7
            if (d % 7 == 0 || (n >= 3)) {
                System.out.print(7 + " ");
            }

            // for 9
            if (n >= 6 || (n >= 3 && d % 3 == 0) || d % 9 == 0) {
                System.out.print(9 + " ");
            }

            System.out.println();
        }
    }
}