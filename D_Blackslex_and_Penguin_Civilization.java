import java.util.*;

public class D_Blackslex_and_Penguin_Civilization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int limit = 1 << n;

            boolean[] u = new boolean[limit];
            ArrayList<Integer> ans = new ArrayList<>();

            for (int k = n; k >= 1; k--) {
                int m = (1 << k) - 1;

                if (m >= limit || u[m])
                    continue;

                ans.add(m);
                u[m] = true;

                int mask = (1 << k) - 1;

                for (int x = 0; x < limit; x++) {
                    if (!u[x] && (x & mask) == mask) {
                        ans.add(x);
                        u[x] = true;
                    }
                }
            }

            for (int x = 0; x < limit; x++) {
                if (!u[x]) {
                    ans.add(x);
                }
            }

            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}