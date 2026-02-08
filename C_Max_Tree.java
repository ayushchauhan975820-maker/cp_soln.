import java.util.*;
import java.io.BufferedReader; // Import for fast I/O
import java.io.IOException; // Import for fast I/O
import java.io.InputStreamReader; // Import for fast I/O
import java.util.StringTokenizer; // Import for fast I/O

public class C_Max_Tree {

    // --- Fast I/O Reader Class ---
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    // --- End of Fast I/O Class ---

    public static void main(String[] args) {
        FastReader sc = new FastReader(); // Use FastReader instead of Scanner

        int t = sc.nextInt();

        // Use StringBuilder to collect all output
        StringBuilder output = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();

            // build adj graph
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int indeg[] = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int x = sc.nextInt();
                int y = sc.nextInt();

                if (x > y) {
                    // edge from v -> u
                    list.get(v).add(u);
                    indeg[u]++;
                } else {
                    // edge from u -> v
                    list.get(u).add(v);
                    indeg[v]++;
                }
            }

            // kahn's algo
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (indeg[i] == 0) {
                    q.offer(i);
                }
            }

            int arr[] = new int[n + 1];
            int val = 1;

            while (!q.isEmpty()) {
                int cur = q.poll();
                arr[cur] = val++;

                for (int i = 0; i < list.get(cur).size(); i++) {
                    int neigh = list.get(cur).get(i);
                    indeg[neigh]--;
                    if (indeg[neigh] == 0) {
                        q.offer(neigh);
                    }
                }
            }

            // Append this test case's answer to the StringBuilder
            for (int i = 1; i <= n; i++) {
                output.append(arr[i]).append(" ");
            }
            output.append("\n"); // Add a newline after each test case
        }

        // Print the entire collected output at once
        System.out.print(output);
    }
}