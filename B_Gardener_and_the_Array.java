import java.util.*;

public class B_Gardener_and_the_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            // if a bit is one then its 1
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int len = sc.nextInt();
                list.add(new ArrayList<>());
                for (int j = 0; j < len; j++) {
                    int idx = sc.nextInt();
                    --idx;
                    list.get(i).add(idx);
                    map.put(idx, map.getOrDefault(idx, 0) + 1);
                }
            }

            boolean broken = false;
            for (int i = 0; i < n; i++) {
                boolean valid = false;
                for (int j = 0; j < list.get(i).size(); j++) {
                    if (map.get(list.get(i).get(j)) == 1) {
                        valid = true;
                    }
                }
                if (!valid) {
                    broken = true;
                    break;
                }
            }

            if (broken)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}