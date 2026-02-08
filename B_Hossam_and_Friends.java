import java.util.*;

public class B_Hossam_and_Friends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < m; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();

                int max = Math.max(s, e);
                int min = Math.min(s, e);

                if (map.containsKey(max)) {
                    map.put(max, Math.max(map.get(max), min));
                } else {
                    map.put(max, min);
                }
            }
            long count = 0;
            int l = 0;
            for (int i = 0; i < n; i++) {
                int val = i + 1;

                if (map.containsKey(val)) {
                    l = Math.max(l, map.get(val));
                }

                count += i - l + 1;
            }

            System.out.println(count);
        }
    }

    /*
     * 1 to n people in the line
     * 
     * sort on end basis
     * for a idx i previous element must be +1 to be closest range ending to c
     */

}