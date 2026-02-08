import java.util.*;

public class E_Vlad_and_a_Pair_of_Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            long xor = sc.nextLong();
            int msb = -1;
            // check two set
            boolean set = false;
            for (int i = 30; i >= 0; i--) {
                if (((xor & (1 << i)) != 0) && msb == -1) {
                    msb = i;
                }

                if (((xor & (1 << i)) != 0) && ((xor & (1 << (i + 1))) != 0)) {
                    set = true;
                    break;
                }
            }
            if (set || xor % 2 != 0) {
                System.out.println(-1);
                continue;
            }

            // building nos.
            int a = 0;
            int b = 0;
            for (int i = 0; i <= msb; i++) {

                if (((xor & (1 << i)) != 0)) {
                    // set a
                    a = a | (1 << i);
                } else {
                    // i + 1 is set then 1 1 else 0 0
                    if ((xor & (1 << (i + 1))) != 0) {
                        // set both
                        a = a | (1 << i);
                        b = b | (1 << i);
                    }
                }
            }

            System.out.println(a + " " + b);
        }
    }

    /*
     * a ^ b = (a + b)/2
     * 
     * 1) a+b is even so either a is e and b is e or a is o and b is o so xor cant
     * be odd
     * 
     * 2) if two continous bit of xor is set then not possible
     * 
     * 
     */

}