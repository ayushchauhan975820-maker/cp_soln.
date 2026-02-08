import java.util.*;

public class B_Find_the_Permutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            char[][] g = new char[n][n];
            for (int i = 0; i < n; i++) {
                g[i] = sc.next().toCharArray();
            }

            // Using 1-based indexing for vertices (1 to n)
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }
            int[] indeg = new int[n + 1];

            // 1. Build the new DIRECTED graph
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    // Check the given adjacency matrix (using 0-based index)
                    if (g[i - 1][j - 1] == '1') {
                        // Edge means smaller value (i) comes before larger (j)
                        adj.get(i).add(j); // Edge i -> j
                        indeg[j]++;
                    } else {
                        // No edge means larger value (j) comes before smaller (i)
                        adj.get(j).add(i); // Edge j -> i
                        indeg[i]++;
                    }
                }
            }

            // 2. Standard Topological Sort (Kahn's Algorithm)
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (indeg[i] == 0) {
                    q.add(i);
                }
            }

            List<Integer> p = new ArrayList<>();
            while (!q.isEmpty()) {
                int u = q.poll();
                p.add(u);

                for (int v : adj.get(u)) {
                    indeg[v]--;
                    if (indeg[v] == 0) {
                        q.add(v);
                    }
                }
            }

            // 3. Print the result
            for (int i = 0; i < n; i++) {
                System.out.print(p.get(i) + (i + 1 < n ? " " : ""));
            }
            System.out.println();
        }
    }
}