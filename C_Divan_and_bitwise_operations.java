import java.util.*;

public class C_Divan_and_bitwise_operations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            long mod = (long) (1e9 + 7);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
                a[i][2] = sc.nextInt();
            }

        }
    }

    /*
     * coz = sum of bitwise xor of all the subsequences
     * 
     * bitwise or of some segments are given
     * 
     * a(x1&x3) b(x1&x2&x3) c(x2&x3)
     * l1 r1 = x1
     * l2 r2 = x2
     * l3 r3 = x3
     * 
     */
}