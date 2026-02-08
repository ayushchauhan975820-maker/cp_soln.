import java.util.*;

public class D_Wooden_Toy_Festival {
    public static boolean ch(long arr[], int dis) {
        int l = 0;
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if ((long) (arr[i] - arr[l]) > 2L * dis) {
                l = i;
                count++;
            }

            if (count >= 3)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            Arrays.sort(a);

            int l = 0;
            int r = (int) (1e9);
            int ans = 0;
            while (l <= r) {
                int mid = l + (r - l) / 2;

                boolean ch = ch(a, mid);
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

    /*
     * pick any x such that we can minimize the difference b/w coords
     * 
     * pick such min time
     * 
     * time = |x - y|
     * 
     * 
     * 1 4 4 14 19 37 59 73 98
     * 
     * 1 3 10 11 15 17
     * 
     * 1 7 7
     * 
     */

}