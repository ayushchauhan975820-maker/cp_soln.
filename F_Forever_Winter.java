import java.util.*;

public class F_Forever_Winter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int vertices = sc.nextInt();
            int edges = sc.nextInt();

            int deg[] = new int[vertices];
            for (int i = 0; i < edges; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                deg[u] += 1;
                deg[v] += 1;
            }

            int xy = 0;
            for (int i = 0; i < vertices; i++) {
                if (deg[i] == 1) {
                    xy++;
                }
            }

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < vertices; i++) {
                if (deg[i] != 1) {
                    map.put(deg[i], map.getOrDefault(deg[i], 0) + 1);
                }
            }

            int x = 0;
            int y = 0;
            if (map.size() >= 2) {
                for (int freq : map.keySet()) {
                    if (map.get(freq) == 1)
                        x = freq;
                    else
                        y = freq - 1;
                }
            } else {
                int d1 = map.firstKey();

                x = d1;
                y = x - 1;
            }

            System.out.println(x + " " + y);
        }
    }
}