import java.util.*;

public class C_Scoring_Subsequences {

    public static int bs(int arr[], int end) {
        // end - i + 1
        int l = 0;
        int r = end;
        int ans = end;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            int idx = end - mid + 1;
            if (arr[mid] / idx < 1) {
                l = mid + 1;
            } else {
                ans = mid;
                r = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                int idx = bs(a, i);

                int len = i - idx + 1;

                System.out.print(len + " ");
            }
            System.out.println();
        }
        /*
         * [s1, s2, s3, s4] = s1/1 . s2/2 . s3/3 . s4/4
         * 
         * a, b, c, d, e = e/1 d/2 c/3 b/4 .. add till x/l > 1 how will i find it
         * check for every suffix
         * 
         * lets try for binary search
         * first element such that a[i]/mid > 1
         */
    }
}