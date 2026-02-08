import java.util.*;

public class C_Manhattan_Permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long max = Math.max(0, n * (long) n - 2 * n + ((n % 2 == 0) ? 0 : 2 * ((n + 1) / 2) - 1));
            if (k % 2 == 0 || k > max) {
                System.out.println("No");
                continue;
            }

            // contruct

        }
    }

    /*
            
    
    */

}