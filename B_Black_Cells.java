import java.util.*;

public class B_Black_Cells {
    public static boolean ch(long arr[], long k) {
        int n = arr.length;

        if (n % 2 == 0) {
            // check for middle pair
            int count = 0;
            for (int i = 1; i < n; i += 2) {
                if (arr[i] - arr[i - 1] > k)
                    count++;
            }

            if (count >= 1)
                return false;
            return true;
        } else {
            int count1 = 0;
            int count2 = 0;
            // check first as default
            for (int i = 2; i < n; i += 2) {
                if (arr[i] - arr[i - 1] > k)
                    count1++;
            }

            // check second as default
            for (int i = 1; i < n - 1; i += 2) {
                if (arr[i] - arr[i - 1] > k)
                    count2++;
            }

            if (count1 < 1 || count2 < 1)
                return true;
            else
                return false;
        }
    }

    // public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);

    // int t = sc.nextInt();
    // while (t-- > 0) {
    // int n = sc.nextInt();

    // long a[] = new long[n];
    // for (int i = 0; i < n; i++) {
    // a[i] = sc.nextLong();
    // }
    // Arrays.sort(a);
    // long l = 1;
    // long r = (long) (1e18);
    // long dis = r;
    // while (l <= r) {
    // long mid = l + (r - l) / 2;

    // boolean ch = ch(a, mid);
    // if (ch) {
    // dis = mid;
    // r = mid - 1;
    // } else {
    // l = mid + 1;
    // }
    // }

    // System.out.println(dis);
    // }

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

            if (n % 2 == 0) {
                // check for max
                long max = 1;
                for (int i = 1; i < n; i += 2) {
                    max = Math.max(max, a[i] - a[i - 1]);
                }

                System.out.println(max);

            } else {
                long min = Long.MAX_VALUE;
                // check by reomving all
                for (int i_to_remove = 0; i_to_remove < n; i_to_remove++) {
                    // 1. Build the new array 'b' without arr[i_to_remove]
                    long b[] = new long[n - 1];
                    int b_idx = 0;
                    for (int j = 0; j < n; j++) {
                        if (j != i_to_remove) {
                            b[b_idx++] = a[j];
                        }
                    }

                    long max = 1;
                    for (int i = 1; i < n; i += 2) {
                        max = Math.max(max, b[i] - b[i - 1]);
                    }

                    min = Math.min(min, max);

                }

                System.out.println(min);
            }

        }
    }

    /*
     * go for O(n^2)
     * 
     * check for last
     * 
     * if pair is starting with i we have to +2 it
     * if pair is not starting then it must be in left on cur - 2 else cur - 1
     */

}