import java.util.*;

public class C_1_The_Cunning_Seller_easy_version {
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
            long sum = 0;
            long val = n;

            for (int i = 18; i >= 0; i--) {
                if (pow[i] <= val) {
                    long div = val / pow[i];
                    val -= div * pow[i];
                    sum += (div * cost[i]);
                }
            }

            System.out.println(sum);
        }
    }

    /*
        
    */

}