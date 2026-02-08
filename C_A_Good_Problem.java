import java.util.*;

public class C_A_Good_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            Long n = sc.nextLong();
            long l = sc.nextLong();
            long r = sc.nextLong();
            long k = sc.nextLong();

            if (n % 2 != 0) {
                System.out.println(l);
                continue;
            }

            // if even
            // finding no. inverse of l
            int msb = 62;
            for (int i = 61; i >= 0; i--) {
                if ((l & (1L << i)) != 0) {
                    msb = i;
                    break;
                }
            }
            long a = 0;
            // build set msb + 1 and first lsb
            a = a | (1L << (msb + 1));

            if (a > r || n == 2) {
                System.out.println(-1);
            } else {
                if (k == n || k == n - 1) {
                    System.out.println(a);
                } else {
                    System.out.println(l);
                }
            }
        }
    }

    /*
     * using no b/w l and r build array of size n such that xor of aray and and of
     * array is same
     * output ak if exist
     * 
     * any set bit can only appear odd no of times
     * 
     * so if n is odd all can be l
     * 
     * 0 1 1 0
     * 0 1 1 0
     * 
     */

}