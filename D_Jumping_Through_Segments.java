import java.util.*;

public class D_Jumping_Through_Segments {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            long ans = -1;
            long l = 0;
            long r = (long) (1e9);
            while (l <= r) {
                long mid = l + (r - l) / 2;

                boolean ch = calc(arr, mid);
                if (ch) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            System.out.println(ans);
        }
    }

    public static boolean calc(int arr[][], long k) {
        int n = arr.length;
        long s = 0;
        long e = 0;

        for (int i = 0; i < n; i++) {
            long l = (long) arr[i][0];
            long r = (long) arr[i][1];
            s = s - k;
            e = e + k;

            s = Math.max(l, s);
            e = Math.min(r, e);

            if (s > e)
                return false;
        }

        return true;
    }
}