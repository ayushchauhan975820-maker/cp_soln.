import java.util.*;

public class D_1_Removal_of_a_Sequence_Easy_Version {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            long inf = (long) (1e12 + 1);
            long x = sc.nextLong();
            long y = sc.nextLong();
            long k = sc.nextLong();

            long l = 1;
            long r = inf;
            while (l <= r) {
                long mid = l + (r - l) / 2;

                long ch = mid - 1;
                for (int i = 0; i < x; i++) {
                    ch -= ch / y;
                }

                if (ch + 1 > k) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            if (r == inf)
                System.out.println(-1);
            else
                System.out.println(r);
        }
    }

    /*
        
    */

}