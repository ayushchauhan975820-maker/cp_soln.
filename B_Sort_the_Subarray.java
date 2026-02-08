import java.util.*;

public class B_Sort_the_Subarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            int l = n;
            int r = 1;
            for (int i = 1; i <= n; i++) {
                if (a[i - 1] != b[i - 1]) {
                    l = Math.min(l, i);
                    r = Math.max(r, i);
                }
            }

            while (l > 1 && b[l - 2] <= b[l - 1] && b[l - 2] == a[l - 2]) {
                l--;
            }

            while (r < n && b[r] >= b[r - 1] && b[r] == a[r]) {
                r++;
            }

            System.out.println(l + " " + r);
        }
    }
}