import java.util.*;

public class E_Negatives_and_Positives {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int negs = 0;
            long sum = 0;
            long arr[] = new long[n];
            long min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
                if (arr[i] < 0) {
                    negs++;
                    arr[i] = -arr[i];
                }
                min = Math.min(min, arr[i]);
                sum += arr[i];
            }

            if (negs % 2 != 0)
                sum = sum - 2 * min;

            System.out.println(sum);
        }
    }
}