import java.util.*;

public class A_Pizza_Time {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();

            if (n < 5) {
                System.out.println(1);
                continue;
            }

            long ans = (n - 3) / 2 + 1;

            System.out.println(ans);
        }
    }

    /*
     * x - slices
     * save 3
     * [divide rest in half] + 1
     * 
     * if atleast 5 are needed
     */

}