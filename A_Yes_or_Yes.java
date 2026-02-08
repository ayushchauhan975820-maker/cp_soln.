import java.util.*;

public class A_Yes_or_Yes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'Y')
                    count++;
            }

            if (count > 1)
                System.out.println("NO");
            else
                System.out.println("YES");

        }
    }

    /*
        
    */

}