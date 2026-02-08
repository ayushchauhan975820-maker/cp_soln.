import java.util.*;

public class B_Your_Name {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();
            HashMap<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);

                map.put(c1, map.getOrDefault(c1, 0) + 1);
                map.put(c2, map.getOrDefault(c2, 0) - 1);
            }

            boolean valid = true;
            for (int val : map.values()) {
                if (val != 0) {
                    valid = false;
                    break;
                }
            }

            if (valid)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    /*
        
    */

}