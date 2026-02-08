import java.util.*;

public class A_Shizuku_Hoshikawa_and_Farm_Legs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int ans = 0;
            for (int i = 0; i <= n; i += 2) {
                if (i % 2 == 0 && (n - i) % 4 == 0) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }

    /*
        
    */

}