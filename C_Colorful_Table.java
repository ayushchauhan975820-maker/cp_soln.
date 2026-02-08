import java.util.*;

public class C_Colorful_Table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int l[] = new int[k + 1];
            int r[] = new int[k + 1];
            Arrays.fill(l, n + 1);
            Arrays.fill(r, -1);
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int val = a[i];
                if (l[val] == n + 1) {
                    l[val] = i + 1;
                }

                r[val] = i + 1;
                set.add(val);
            }

            int ml[] = new int[k + 1];
            int mr[] = new int[k + 1];
            ml[k] = l[k];
            mr[k] = r[k];
            for (int i = k - 1; i > 0; i--) {
                ml[i] = Math.min(l[i], ml[i + 1]);
                mr[i] = Math.max(r[i], mr[i + 1]);
            }

            for (int i = 1; i <= k; i++) {
                if (!set.contains(i)) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print((2 * (mr[i] - ml[i] + 1)) + " ");
                }
            }
            System.out.println();
        }

        /*
         * get value from a[i]
         * for l minimise i
         * for r maximise i
         * 
         * prefix check for max k
         */
    }
}