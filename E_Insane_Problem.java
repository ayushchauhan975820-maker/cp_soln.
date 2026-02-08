import java.util.*;

public class E_Insane_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            long k = sc.nextLong();
            long l1 = sc.nextLong();
            long r1 = sc.nextLong();
            long l2 = sc.nextLong();
            long r2 = sc.nextLong();

            long ans = 0;
            long pow = 1;
            for (int i = 0; i < 32; i++) {
                if (pow > r2)
                    break;

                long xmin = (l2 + pow - 1) / pow;
                if (xmin < l1)
                    xmin = l1;

                long xmax = (r2 / pow);
                if (xmax > r1)
                    xmax = r1;

                if (xmin <= xmax) {
                    ans += (xmax - xmin + 1);
                }

                if (pow > r2 / k)
                    break;
                pow = pow * k;
            }

            System.out.println(ans);
        }
    }

    /*
        
    */

}