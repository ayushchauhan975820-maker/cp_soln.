import java.util.*;

public class B_Impost_or_Sus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            int count = 0;
            char a[] = s.toCharArray();
            a[0] = 's';
            a[n - 1] = 's';
            if (s.charAt(0) == 'u') {
                count++;
            }
            if (s.charAt(n - 1) == 'u') {
                count++;
            }

            int tot = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == 's') {
                    count += tot / 2;
                    tot = 0;
                } else {
                    tot++;
                }
            }

            System.out.println(count);
        }
    }

    /*
        
    */

}