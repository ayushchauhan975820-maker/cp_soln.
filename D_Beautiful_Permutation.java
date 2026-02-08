import java.util.*;

public class D_Beautiful_Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int L = 1;
            int R = n;
            System.out.println("1 " + L + " " + R);
            System.out.flush();
            int orSum = sc.nextInt();

            System.out.println("2 " + L + " " + R);
            System.out.flush();
            int modSum = sc.nextInt();
            int changed = modSum - orSum;

            while (L < R) {
                int mid = L + (R - L) / 2;

                System.out.println("1 " + L + " " + mid);
                System.out.flush();
                int ordSum = sc.nextInt();

                System.out.println("2 " + L + " " + mid);
                System.out.flush();
                int modiSum = sc.nextInt();

                int left = modiSum - ordSum;

                if (left == 0) {
                    L = mid + 1;
                } else {
                    R = mid;
                }
            }
            int l = L;
            int r = l + changed - 1;
            System.out.println("! " + l + " " + r);
            System.out.flush();
        }
    }
}