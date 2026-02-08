import java.util.*;

public class C_Loyalty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long x = sc.nextLong();

            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            TreeMap<Long, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }
            ArrayList<Long> list = new ArrayList<>();
            long ans = 0;
            long s = 0;
            for (int i = 0; i < n; i++) {
                long before = s / x;
                long com = s % x;
                long left = x - com;

                Long p = null;
                SortedMap<Long, Integer> tail = map.tailMap(left, true);
                if (!tail.isEmpty()) {
                    p = tail.lastKey();
                } else {
                    p = map.firstKey();
                }

                list.add(p);
                s += p;
                long after = s / x;
                if (after > before)
                    ans += p;

                int cnt = map.get(p);
                if (cnt == 1)
                    map.remove(p);
                else
                    map.put(p, cnt - 1);

            }

            System.out.println(ans);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    /*
        
    */

}