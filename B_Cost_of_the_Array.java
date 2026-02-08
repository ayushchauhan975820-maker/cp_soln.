import java.util.*;

public class B_Cost_of_the_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            if (k == n) {
                int ans = 1;
                for (int i = 1; i < n; i += 2) {
                    if (a[i] != ans)
                        break;
                    ans++;
                }

                System.out.println(ans);
                continue;
            }

            boolean allOne = true;
            for (int i = 1; i < n - k + 2; i++) {
                if (a[i] != 1) {
                    allOne = false;
                    break;
                }
            }

            if (allOne) {
                System.out.println(2);
            } else
                System.out.println(1);
        }
    }

    /*
     * max cost must be mex of the array
     * 
     * min cost to be x -
     * can be avoid x to get into the xth even list
     * 
     * for 1
     * 
     * it will be
     * ((2i - 1) to n - k + (2i) if in this range any number other than i is
     * present it is
     * 
     * 
     * 
     * 
     * 
     */

}