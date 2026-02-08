import java.util.*;

public class A_Round_Trip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            Long r = sc.nextLong();
            long x = sc.nextLong();
            long d = sc.nextLong();
            long n = sc.nextLong();

            String s = sc.next();
            int count = 0;
            long cur = r;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '2') {
                    if (cur < x) {
                        count++;
                    }
                } else {
                    count++;
                    cur = Math.max(0, cur - d);
                }
            }

            System.out.println(count);
        }
    }

    /*
        
    */

}