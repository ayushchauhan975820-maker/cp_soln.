import java.util.*;

public class C_Monopati {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int g[][] = new int[2][n];
            for (int i = 0; i < n; i++) {
                g[0][i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                g[1][i] = sc.nextInt();
            }

            int pmin[] = new int[n];
            int pmax[] = new int[n];
            int smin[] = new int[n];
            int smax[] = new int[n];
            for (int i = 0; i < n; i++) {
                pmin[i] = (i == 0) ? g[0][i] : Math.min(pmin[i - 1], g[0][i]);
                pmax[i] = (i == 0) ? g[0][i] : Math.max(pmax[i - 1], g[0][i]);
            }
            for (int i = n - 1; i >= 0; i--) {
                smin[i] = (i == n - 1) ? g[1][i] : Math.min(smin[i + 1], g[1][i]);
                smax[i] = (i == n - 1) ? g[1][i] : Math.max(smax[i + 1], g[1][i]);
            }

            long tot = 0;
            int a[] = new int[2 * n];
            Arrays.fill(a, 2 * n + 1);
            for (int i = 0; i < n; i++) {
                int l = Math.min(pmin[i], smin[i]);
                int r = Math.max(pmax[i], smax[i]);

                a[l - 1] = Math.min(a[l - 1], r);
            }

            for (int i = 2 * n - 2; i >= 0; i--) {
                a[i] = Math.min(a[i], a[i + 1]);
            }

            for (int i = 0; i < 2 * n; i++) {
                tot += 2 * n - a[i] + 1;
            }

            System.out.println(tot);
        }
    }

    /*
        
    */

}