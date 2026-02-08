import java.util.*;

public class C_Yarik_and_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            int[] prefix = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();

                if (i == 0) {
                    prefix[i] = nums[i];
                } else {
                    prefix[i] = prefix[i - 1] + nums[i];
                }
            }

            int l = 0;
            int r = 0;
            int low = 0;
            int max = Integer.MIN_VALUE;
            while (r < n) {
                if (r != 0 && l != r && ((nums[r] % 2 + 2) % 2) == ((nums[r - 1] % 2 + 2) % 2)) {
                    l = r;
                    low = prefix[r - 1];
                }

                int val = prefix[r] - low;
                low = Math.min(low, prefix[r]);
                max = Math.max(max, val);

                r++;
            }

            System.out.println(max);
        }
    }
}