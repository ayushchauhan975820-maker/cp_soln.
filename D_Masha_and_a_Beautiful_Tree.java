import java.util.*;

public class D_Masha_and_a_Beautiful_Tree {
    public static int[] solve(int arr[], int l, int r) {
        if (l == r) {
            return new int[] { arr[l], arr[l], 0 };
        }

        int mid = l + (r - l) / 2;

        int[] left = solve(arr, l, mid);
        int[] right = solve(arr, mid + 1, r);
        int lmin = left[0];
        int lmax = left[1];
        int lc = left[2];
        int rmin = right[0];
        int rmax = right[1];
        int rc = right[2];

        if (lc == -1 || rc == -1)
            return new int[] { -1, -1, -1 };

        if (lmin <= rmin && lmax <= rmax && lmax <= rmin)
            return new int[] { Math.min(lmin, rmin), Math.max(rmax, lmax), lc + rc };
        else if (lmin >= rmin && lmax >= rmax && lmin >= rmax)
            return new int[] { Math.min(lmin, rmin), Math.max(rmax, lmax), lc + rc + 1 };
        else
            return new int[] { -1, -1, -1 };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int ans[] = solve(arr, 0, n - 1);

            System.out.println(ans[2]);
        }
    }
}