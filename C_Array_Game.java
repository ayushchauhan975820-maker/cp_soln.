import java.util.*;

public class C_Array_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long a[] = new long[n];
            long min = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                min = Math.min(min, a[i]);
            }
            if (k >= 3) {
                System.out.println(0);
                continue;
            }
            Arrays.sort(a);
            long newMin = Long.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                newMin = Math.min(newMin, Math.abs(a[i] - a[i - 1]));
            }
            if (k == 1) {
                System.out.println(Math.min(min, newMin));
                continue;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    long val = a[i] - a[j];
                    long low = bslow(a, n, val);
                    long high = bshigh(a, n, val);
                    long diffl = low == -1 ? Long.MAX_VALUE : Math.abs(val - low);
                    long diffh = high == -1 ? Long.MAX_VALUE : Math.abs(val - high);
                    min = Math.min(min, val);
                    min = Math.min(min, Math.min(diffh, diffl));
                }
            }

            System.out.println(min);
        }
    }

    public static long bslow(long a[], int n, long num) {
        long low = -1L;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] <= num) {
                low = a[mid];
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return low;
    }

    public static long bshigh(long a[], int n, long num) {
        long high = -1L;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] < num) {
                l = mid + 1;
            } else {
                high = a[mid];
                r = mid - 1;
            }
        }
        return high;
    }

    /*
        
    */

}