import java.util.*;

public class B_Lunatic_Never_Content {
    public static int GCD(int a, int b) {
        if (b == 0)
            return a;

        return GCD(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int nums[] = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int ans = 0;

            int l = 0;
            int r = n - 1;
            while (l <= r) {
                int a = nums[l];
                int b = nums[r];
                l++;
                r--;
                if (a == 0 && b == 0) {
                    continue;
                }

                ans = GCD(ans, Math.abs(a - b));
            }

            System.out.println(ans);
        }
    }
}