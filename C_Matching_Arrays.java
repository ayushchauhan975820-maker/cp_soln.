import java.util.*;

public class C_Matching_Arrays {
    static class Pair {
        long val;
        int idx;

        Pair(long v, int i) {
            val = v;
            idx = i;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            Pair[] a = new Pair[n];
            for (int i = 0; i < n; i++) {
                long v = sc.nextLong();
                a[i] = new Pair(v, i);
            }

            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextLong();
            }

            Arrays.sort(a, Comparator.comparingLong(p -> p.val));
            Arrays.sort(b);

            long ans[] = new long[n];
            for (int i = 0; i < x; i++) {
                ans[n - x + i] = b[i];
            }
            for (int i = x; i < n; i++) {
                ans[i - x] = b[i];
            }

            if (!calcB(n, x, a, ans)) {
                System.out.println("NO");
            } else {
                // map back to original indices
                long[] res = new long[n];
                for (int i = 0; i < n; i++) {
                    int originalIndex = a[i].idx;
                    res[originalIndex] = ans[i];
                }

                System.out.println("YES");
                for (int i = 0; i < n; i++) {
                    System.out.print(res[i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static boolean calcB(int n, int x, Pair[] a, long[] b) {
        int tot = 0;
        for (int i = 0; i < n; i++) {
            if (a[i].val > b[i]) {
                tot++;
            }
        }
        return tot == x;
    }

    /*
     * every no b/w 1 -> n*m must appear
     */

}