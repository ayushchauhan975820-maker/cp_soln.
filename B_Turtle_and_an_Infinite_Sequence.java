import java.util.*;

public class B_Turtle_and_an_Infinite_Sequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            long rmax = (long) n + m;
            long rmin = Math.max(0, (long) n - m);
            long ans = 0;
            for (int i = 31; i >= 0; i--) {
                if (((rmin & (1L << i)) != 0) || ((rmax & (1L << i)) != 0)
                        || ((rmin >> (i + 1L)) != (rmax >> (i + 1L)))) {
                    ans = ans | (1L << i);
                }
            }

            System.out.println(ans);
        }
    }

    /*
        
    */

}