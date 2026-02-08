import java.util.*;

public class D_Yarik_and_Musical_Notes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            HashMap<Integer, Long> freq = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                freq.put(a, freq.getOrDefault(a, 0L) + 1);
            }

            long count = 0;

            // Same-number pairs
            for (long f : freq.values()) {
                count += f * (f - 1) / 2;
            }

            // Cross pairs (1,2)
            long c1 = freq.getOrDefault(1, 0L);
            long c2 = freq.getOrDefault(2, 0L);
            count += c1 * c2;

            System.out.println(count);
        }
    }
}

// ***************************** //
// correct but giving tle

/*
 * import java.util.*;
 * 
 * public class D_Yarik_and_Musical_Notes {
 * public static void main(String[] args) {
 * Scanner sc = new Scanner(System.in);
 * 
 * int t = sc.nextInt();
 * while (t-- > 0) {
 * int n = sc.nextInt();
 * 
 * long count = 0;
 * HashMap<Integer, Integer> map = new HashMap<>();
 * for (int i = 0; i < n; i++) {
 * int a = sc.nextInt();
 * 
 * if (map.containsKey(a)) {
 * count += (long) map.get(a);
 * }
 * 
 * if (a == 2) {
 * count += (long) map.getOrDefault(1, 0);
 * }
 * if (a == 1) {
 * count += (long) map.getOrDefault(2, 0);
 * }
 * 
 * map.put(a, map.getOrDefault(a, 0) + 1);
 * }
 * 
 * System.out.println(count);
 * }
 * }
 * }
 */
