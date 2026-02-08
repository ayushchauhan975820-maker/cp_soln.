import java.util.*;

public class B_pspspsps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            char a[] = s.toCharArray();
            if (a[0] == 's')
                a[0] = '.';
            if (a[n - 1] == 'p')
                a[n - 1] = '.';
            int pcount = 0;
            int scount = 0;

            for (int i = 0; i < n; i++) {
                if (a[i] == 'p')
                    pcount++;
                if (a[i] == 's')
                    scount++;
            }

            if (pcount == 0 || scount == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    /*
     * ps is invalid as we want permutation to start on s and end on p
     * 
     */

}