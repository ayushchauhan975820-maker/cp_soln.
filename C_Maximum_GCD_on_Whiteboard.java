import java.util.*;

public class C_Maximum_GCD_on_Whiteboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }

            int prefix[] = new int[n + 1];
            prefix[1] = map.getOrDefault(1, 0);
            for (int i = 2; i <= n; i++) {
                prefix[i] = prefix[i - 1] + map.getOrDefault(i, 0);
            }

            int ans = 1;
            for (int i = 2; i <= n; i++) {
                int min = ((4 * i) > n) ? prefix[n] : prefix[4 * i - 1];
                int f = map.getOrDefault(i, 0);
                int s = map.getOrDefault(2 * i, 0);
                int th = map.getOrDefault(3 * i, 0);

                if (min - f - s - th <= k) {
                    ans = i;
                }
            }

            System.out.println(ans);
        }
    }

    /*
     * how many no we will use erase on
     * (x < 4g) - (x == g) - (x == 2g) - (x == 3g)
     * 
     */

}