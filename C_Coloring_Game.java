import java.util.*;

public class C_Coloring_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);
            int max = a[n - 1];
            long count = 0;
            for (int i = 2; i < n; i++) {
                int l = 0;
                int r = i - 1;

                while (l < r) {
                    if (a[l] + a[r] > Math.max(a[i], max - a[i])) {
                        count += r - l;
                        r--;
                    } else {
                        l++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    /*
     * bob can pick any so bob will pick highest
     * so it is a threesum preoblem where x + y + z > max(a1, a2, a3)
     * 
     * if bob recolors and sum of 2 must be greater then 3rd
     */

}