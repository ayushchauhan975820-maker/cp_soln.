import java.util.*;

public class C_Make_It_Beautiful {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long p[] = new long[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextLong();
            }

            TreeMap<Integer, Long> map = new TreeMap<>();
            long count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 60; j >= 0; j--) {
                    if ((p[i] & (1L << j)) == 0) {
                        map.put(j, map.getOrDefault(j, 0L) + 1);
                    } else {
                        count++;
                    }
                }
            }

            long ops = k;
            for (int bit : map.keySet()) {
                // can set 1 bit
                long uin = map.get(bit);

                long needed_for_one = (1L << bit);
                long have = Math.min(uin, ops / needed_for_one);

                // long added = have / needed_for_one;
                count += have;
                ops -= needed_for_one * have;
            }

            System.out.println(count);
        }
    }

    /*
        
    */

}