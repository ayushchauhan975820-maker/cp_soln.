import java.util.*;

public class E_Building_an_Aquarium {
    public static boolean isPos(long arr[], long h, int w) {
        int n = arr.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long num = arr[i];
            if (num < h) {
                sum += (h - num);
            }
        }

        return (sum <= w);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int w = sc.nextInt();

            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            long l = 1;
            long r = (long) (1e10);
            long ans = 1;

            while (l <= r) {
                long mid = l + (r - l) / 2;
                boolean ch = isPos(arr, mid, w);

                if (ch) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            System.out.println(ans);
        }
    }
}