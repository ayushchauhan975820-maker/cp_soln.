import java.util.*;

public class D_1_Max_Sum_OR_Easy_Version {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            int a[] = new int[r + 1];
            Arrays.fill(a, -1);

            for (int i = r; i >= 0; i--) {
                if (a[i] == -1) {
                    int msb = fmsb(i);
                    int mask = cm(i, msb);
                    if (mask > r) {
                        mask = i;
                    }
                    a[i] = mask;
                    a[mask] = i;
                }
            }

            long sum = 0;
            for (int i = r; i >= 0; i--) {
                sum += (long) (i | a[i]);
            }

            System.out.println(sum);
            for (int i = 0; i <= r; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }

    public static int fmsb(int n) {
        int msb = -1;
        for (int i = 30; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                msb = i;
                break;
            }
        }

        return msb;
    }

    public static int cm(int n, int msb) {
        int mask = 0;
        for (int i = msb; i >= 0; i--) {
            if ((n & (1 << i)) == 0) {
                mask = mask | (1 << i);
            }
        }

        return mask;
    }

    /*
        
    */

}