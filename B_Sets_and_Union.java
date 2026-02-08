import java.util.*;

public class B_Sets_and_Union {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int len = sc.nextInt();
                list.add(new ArrayList<>());
                for (int j = 0; j < len; j++) {
                    int val = sc.nextInt();
                    list.get(list.size() - 1).add(val);
                    if (!map.containsKey(val)) {
                        map.put(val, new ArrayList<>());
                    }
                    map.get(val).add(i);
                }
            }

            int max = 0;
            // remove each val
            for (int val : map.keySet()) {
                // find all the sets to we removed
                HashMap<Integer, Integer> ch = new HashMap<>();
                for (int i = 0; i < map.get(val).size(); i++) {
                    // count their freq intersection and iterate over them
                    ArrayList<Integer> nl = list.get(map.get(val).get(i));
                    for (int j = 0; j < nl.size(); j++) {
                        int num = nl.get(j);

                        ch.put(num, ch.getOrDefault(num, 0) + 1);
                    }
                }

                int cnt = 0;
                for (int num : ch.keySet()) {
                    int inCh = ch.get(num);
                    int inMap = map.get(num).size();

                    if (inCh == inMap)
                        cnt++;
                }
                int el = 0;
                if (cnt > 0)
                    el = map.size() - cnt;
                max = Math.max(max, el);
            }

            System.out.println(max);
        }
    }
}