import java.util.*;

public class E_2_Unforgivable_Curse_hard_version {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            String s1 = sc.next();
            String s2 = sc.next();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
                map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
            }
            boolean valid = true;
            for (int val : map.values()) {
                if (val != 0) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                System.out.println("NO");
                continue;
            }

            //
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) != s2.charAt(i) && Math.max(i, n - i - 1) < k) {
                    valid = false;
                    break;
                }
            }

            if (!valid)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }

    /*
     * can swap char at a dis k or k + 1 front or back
     * 
     * no of chars must be equal
     * 
     * check for disconnected components i.e. we can swap with everyone except some
     * disconneted components
     *
     */

}