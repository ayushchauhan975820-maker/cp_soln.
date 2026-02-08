import java.util.*;

public class C_Matching_Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            if (n % 2 != 0)
                System.out.println("Yes");
            else {
                System.out.println("No");
                continue;
            }
            int toPair = (n + 1) / 2;
            int toJoin = n - toPair;
            for (int i = 1; i <= n; i++) {
                if (i <= toJoin) {
                    int r = 2 * toPair + i + toJoin;
                    System.out.println(i + " " + r);
                } else {
                    int r = i + toPair;
                    System.out.println(i + " " + r);
                }
            }
        }
    }
}