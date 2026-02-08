import java.util.*;

public class D_Flipper {

    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        int r = 0;
        for (int i = 0; i < n; ++i) {
            if (p[Math.min(n - 1, r + 1)] <= p[Math.min(n - 1, i + 1)]) {
                r = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = r + 1; i < n; ++i)
            ans.add(p[i]);
        ans.add(p[r]);
        for (int i = r - 1; i >= 0; --i) {
            if (p[i] > p[0]) {
                ans.add(p[i]);
            } else {
                for (int j = 0; j <= i; ++j) {
                    ans.add(p[j]);
                }
                break;
            }
        }

        for (int e : ans) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tt = 0; tt < t; tt++) {
            solve(sc);
        }
    }
}
