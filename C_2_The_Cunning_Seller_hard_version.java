import java.util.*;

public class C_2_The_Cunning_Seller_hard_version {
    public static long pow[] = new long[19];
    public static long cost[] = new long[19];

    public static void calc() {
        pow[0] = 1;
        cost[0] = 3;
        cost[1] = 10;
        for (int i = 1; i < 19; i++) {
            pow[i] = pow[i - 1] * 3L;
            if (i > 1) {
                cost[i] = pow[i - 1] * (9L + i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        calc();
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();

            long times = 0;
            long val = n;
            long c[] = new long[19];
            for (int i = 18; i >= 0; i--) {
                if (pow[i] <= val) {
                    long div = val / pow[i];
                    val -= div * pow[i];
                    times += div;
                    c[i] = div;
                }
            }

            if (times > k) {
                System.out.println(-1);
                continue;
            }

            for (int i = 18; i > 0; i--) {
                if (c[i] == 0)
                    continue;

                long diff = k - times;
                long div = diff / 2;
                long torem = Math.min(c[i], div);

                c[i] -= torem;
                times += 2 * torem;
                c[i - 1] += 3 * torem;
            }

            long min = 0;
            for (int i = 0; i < 19; i++) {
                min += c[i] * cost[i];
            }

            System.out.println(min);
        }
    }

    /*
     * 1 3x -> 3.3x-1
     * times - +2
     * x dif/2
     * 
     * 10 3 -> 3 1 2*3
     * 
     */

}