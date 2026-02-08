import java.util.*;

public class C_New_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);

            int l = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            int max = 1;
            int count = 1;
            map.put(a[0], 1);
            for (int i = 1; i < n; i++) {
                if (a[i] - a[i - 1] > 1) {
                    map.clear();
                    map.put(a[i], 1);
                    count = 1;
                    l = i;
                } else {
                    map.put(a[i], map.getOrDefault(a[i], 0) + 1);
                    count++;
                }

                while (l < i && map.size() > k) {
                    int val = map.get(a[l]);

                    if (val == 1)
                        map.remove(a[l]);
                    else
                        map.put(a[l], val - 1);
                    count--;
                    l++;
                }

                if (map.size() <= k) {
                    max = Math.max(max, count);
                }
            }

            System.out.println(max);

        }
    }

    /*
        
    */

}