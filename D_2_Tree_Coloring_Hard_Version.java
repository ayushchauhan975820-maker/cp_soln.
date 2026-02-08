import java.io.*;
import java.util.*;

public class D_2_Tree_Coloring_Hard_Version {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = fs.nextInt();
        while (t-- > 0) {
            solve(fs, out);
        }
        out.close();
    }

    static void solve(FastScanner fs, PrintWriter out) {
        int n = fs.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] parent = new int[n + 1];
        int[] childrenCount = new int[n + 1];
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();

        boolean[] vis = new boolean[n + 1];
        int[] q = new int[n + 5];
        int head = 0, tail = 0;

        q[tail++] = 1;
        vis[1] = true;
        parent[1] = 0;

        int levelIdx = 0;
        while (head < tail) {
            int size = tail - head;
            ArrayList<Integer> currentLevel = new ArrayList<>(size);
            levels.add(currentLevel);

            for (int i = 0; i < size; i++) {
                int u = q[head++];
                currentLevel.add(u);

                for (int v : adj.get(u)) {
                    if (!vis[v]) {
                        vis[v] = true;
                        parent[v] = u;
                        childrenCount[u]++;
                        q[tail++] = v;
                    }
                }
            }
            levelIdx++;
        }

        int maxW = 0;
        for (ArrayList<Integer> l : levels)
            maxW = Math.max(maxW, l.size());

        int maxChild = 0;
        for (int i = 1; i <= n; i++)
            maxChild = Math.max(maxChild, childrenCount[i]);

        int k = Math.max(maxW, maxChild + 1);

        int[] color = new int[n + 1];
        color[1] = 1;

        int[] seen = new int[k];
        int cookie = 0;

        for (int i = 1; i < levels.size(); i++) {
            ArrayList<Integer> nodes = levels.get(i);
            int m = nodes.size();

            Long[] nodeData = new Long[m];
            for (int j = 0; j < m; j++) {
                int u = nodes.get(j);
                int pColor = color[parent[u]];
                nodeData[j] = (((long) pColor) << 32) | (long) u;
            }

            Arrays.sort(nodeData);

            cookie++;
            for (int j = 0; j < m; j++) {
                int pColor = (int) (nodeData[j] >>> 32);
                int pColorZero = pColor - 1;

                int bannedS = (pColorZero - j) % k;
                if (bannedS < 0)
                    bannedS += k;

                seen[bannedS] = cookie;
            }

            int s = 0;
            while (s < k && seen[s] == cookie) {
                s++;
            }

            for (int j = 0; j < m; j++) {
                int u = (int) (nodeData[j] & 0xFFFFFFFFL);
                int assignedColorZero = (j + s) % k;
                color[u] = assignedColorZero + 1;
            }
        }

        out.println(k);

        ArrayList<ArrayList<Integer>> resultGroups = new ArrayList<>();
        for (int i = 0; i <= k; i++)
            resultGroups.add(new ArrayList<>());

        for (int i = 1; i <= n; i++) {
            resultGroups.get(color[i]).add(i);
        }

        for (int i = 1; i <= k; i++) {
            ArrayList<Integer> group = resultGroups.get(i);
            out.print(group.size());
            for (int u : group) {
                out.print(" " + u);
            }
            out.println();
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}