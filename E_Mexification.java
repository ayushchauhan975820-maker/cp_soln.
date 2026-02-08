import java.util.*;

public class E_Mexification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            int a[] = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }
            int mex = 0;
            while (map.containsKey(mex))
                mex++;

            int mx[] = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                int val = a[i];
                if (val > mex || map.get(val) > 1) {
                    sum += mex;
                    mx[i] = mex;
                } else {
                    sum += val;
                    mx[i] = val;
                }
            }
            if (k == 1) {
                System.out.println(sum);
                continue;
            }
            map.clear();
            for (int i = 0; i < n; i++) {
                map.put(mx[i], map.getOrDefault(mx[i], 0) + 1);
            }

            int dist = 0;
            while (map.containsKey(dist) && map.get(dist) == 1)
                dist++;
            sum = 0;
            int ct = 0;
            for (int i = 0; i < n; i++) {
                int val = mx[i];
                if (val >= dist)
                    ct++;
                else
                    sum += (long) val;
            }

            if (dist == mex) {
                if (k % 2 == 0) {
                    System.out.println(sum + (long) ct * ((long) dist + 1));
                } else {
                    System.out.println(sum + (long) ct * ((long) dist));
                }
            } else {
                if (k % 2 == 0) {
                    System.out.println(sum + (long) ct * ((long) dist));
                } else {
                    System.out.println(sum + (long) ct * ((long) dist + 1));
                }
            }
        }
    }

    /*
     * 6 6 2 4 3 0 1 8
     * 5 5 2 4 3 0 1 5
     * 6 6 2 4 3 0 1 6
     * 
     * all dups and el greater then mex will change
     * 
     * 1 1 0 0 1 1 5 5 4 1 3 3 3
     * 
     * 0 2
     * 0 1
     * 0 1
     * 
     */

}