import java.util.*;

public class A_Copil_Copac_Draws_Trees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[][] = new int[n - 1][2];
            for (int i = 0; i < n - 1; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            int ans = 1;
            ArrayList<ArrayList<int[]>> list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < n - 1; i++) {
                int u = arr[i][0];
                int v = arr[i][1];

                list.get(u).add(new int[] { v, i });
                list.get(v).add(new int[] { u, i });
            }

            boolean vis[] = new boolean[n + 1];
            vis[1] = true;
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] { 1, 0, 1 });
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int idx = cur[0];
                int pos = cur[1];
                int rg = cur[2];
                ans = Math.max(ans, rg);
                for (int i = 0; i < list.get(idx).size(); i++) {
                    int[] neigh = list.get(idx).get(i);
                    int ni = neigh[0];
                    int np = neigh[1];

                    if (!vis[ni]) {
                        vis[ni] = true;
                        if (np < pos) {
                            q.add(new int[] { ni, np, rg + 1 });
                        } else {
                            q.add(new int[] { ni, np, rg });
                        }
                    }
                }
            }

            System.out.println(ans);
        }
    }

    /*
     * so first we have 1 and all the edges connetcing one
     * 
     * then we connect all the vertices to their respective verties
     * 
     * then to their
     * 
     * 5 6
     * 2 4 7 5
     * 1 2 3
     * 
     * 1 -> 3,4 2,5
     * 2 -> 4,2 7,3
     * 3 ->
     * 4 -> 5,6
     * 5 -> 6,1
     * 6 ->
     * 7 ->
     */

}