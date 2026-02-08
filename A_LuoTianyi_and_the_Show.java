import java.util.*;

public class A_LuoTianyi_and_the_Show {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            // no of people
            int n = sc.nextInt();
            // no of seats
            int m = sc.nextInt();
            int lc = 0;
            int rc = 0;
            int a[] = new int[n];
            HashSet<Integer> pos = new HashSet<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] == -1)
                    lc++;
                else if (a[i] == -2)
                    rc++;
                else {
                    pos.add(a[i]);
                }
            }

            int p[] = new int[m + 2];
            for (int i = 1; i <= m; i++) {
                boolean ins = pos.contains(i);
                p[i] = p[i - 1] + ((ins) ? 1 : 0);
            }
            int k = p[m];

            int max = Math.max(k + Math.min(lc, m - k), k + Math.min(rc, m - k));
            for (int i = 0; i < m + 2; i++) {
                if (i != 0 && i != m + 1 && !pos.contains(i))
                    continue;

                int inl = i - p[i];
                int inr = m - i - (k - p[i]);

                int cpl = Math.min(inl, lc);
                int cpr = Math.min(inr, rc);

                max = Math.max(max, cpl + cpr + k);
            }

            System.out.println(max);
        }
    }

    /*
     * at max m can sit
     * if l >= m or r >= m then m can sit
     * 
     * try to find pivot so that we can maximize left - right
     * 
     * check for every pivot
     * 
     */

}