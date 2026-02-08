import java.util.*;

public class C_The_Nether {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
            StringBuilder sb = new StringBuilder(" " + n);
            for (int i = 1; i <= n; i++) {
                sb.append(" " + i);
            }

            for (int i = 1; i <= n; i++) {
                System.out.println("? " + i + sb.toString());
                System.out.flush();
                int len = sc.nextInt();

                if (!map.containsKey(len))
                    map.put(len, new TreeSet<>());
                map.get(len).add(i);
            }

            StringBuilder ans = new StringBuilder("!");
            int max = map.lastKey();
            ans.append(" " + max);
            int node = map.get(max).last();
            ans.append(" " + node);
            int it = max - 1;
            while (it != 0) {
                int neigh = -1;
                for (int key : map.get(it)) {
                    String s = "? " + node + " 2 " + key + " " + node;
                    System.out.println(s);
                    System.out.flush();
                    int is = sc.nextInt();
                    if (is == 2) {
                        neigh = key;
                        break;
                    }
                }
                if (neigh == -1)
                    break;
                node = neigh;
                ans.append(" " + neigh);
                it--;

            }

            System.out.println(ans);
            System.out.flush();
        }
    }

    /*
        
    */

}