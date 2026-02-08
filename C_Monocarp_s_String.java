import java.util.*;

public class C_Monocarp_s_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            String s = sc.next();

            int arr[] = new int[n];
            int prefix[] = new int[n];
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                arr[i] = (ch == 'a') ? 1 : -1;

                prefix[i] = (i == 0) ? arr[i] : prefix[i - 1] + arr[i];
            }

            //
            int todel = prefix[n - 1];
            if (todel == 0) {
                System.out.println(0);
                continue;
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int min = n + 1;
            for (int i = 0; i < n; i++) {
                // find subarray with sum x
                int toFind = prefix[i] - todel;
                if (map.containsKey(toFind)) {
                    int idx = map.get(toFind);
                    min = Math.min(min, i - idx);
                }

                map.put(prefix[i], i);
            }

            System.out.println((min >= n) ? -1 : min);
        }
    }

    /*
     * 
     * 
     * 1 2 1 0 1 2 3 2 1 2 3 2
     * 
     * prefix - x = prefix[l]
     * 
     */

}