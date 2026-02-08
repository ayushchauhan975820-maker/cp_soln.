import java.util.*;

public class C_Dungeon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[m];
            int[] c = new int[m];

            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            for (int i = 0; i < m; i++)
                b[i] = sc.nextInt();
            for (int i = 0; i < m; i++)
                c[i] = sc.nextInt();

            PriorityQueue<Integer> swords = new PriorityQueue<>();
            for (int x : a)
                swords.add(x);

            TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
            TreeMap<Integer, Integer> withz = new TreeMap<>();

            for (int i = 0; i < m; i++) {
                if (c[i] == 0) {
                    withz.put(b[i], withz.getOrDefault(b[i], 0) + 1);
                } else {
                    map.putIfAbsent(b[i],
                            new PriorityQueue<>(Collections.reverseOrder()));
                    map.get(b[i]).add(c[i]);
                }
            }

            int count = 0;
            ArrayList<Integer> rest = new ArrayList<>();

            while (!swords.isEmpty()) {
                int sw = swords.poll();

                Integer key = map.floorKey(sw);
                if (key == null) {
                    rest.add(sw);
                    continue;
                }

                PriorityQueue<Integer> pq = map.get(key);
                int upgrade = pq.poll();
                count++;

                sw = Math.max(sw, upgrade);
                swords.add(sw);

                if (pq.isEmpty())
                    map.remove(key);
            }

            Collections.sort(rest);
            for (int i = 0; i < rest.size(); i++) {
                Integer key = withz.floorKey(rest.get(i));
                if (key != null) {
                    count++;
                    int val = withz.get(key);
                    if (val == 1)
                        withz.remove(key);
                    else
                        withz.put(key, val - 1);
                }
            }

            System.out.println(count);
        }
    }
}