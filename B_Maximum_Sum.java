import java.util.*;

public class B_Maximum_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long sum = 0;
            int arr[] = new int[n];
            long prefix[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < n; i++) {
                if (i == 0)
                    prefix[i] = arr[i];
                else
                    prefix[i] = prefix[i - 1] + arr[i];
            }
            int r = k;
            while (r >= 0) {
                int min = 2 * r;
                int max = n - 1 - (k - r);

                long sub = (min == 0) ? 0 : prefix[min - 1];
                sum = Math.max(sum, prefix[max] - sub);

                r--;
            }

            System.out.println(sum);
        }
    }
}