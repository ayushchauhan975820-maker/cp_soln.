import java.util.*;

public class B_Distinct_Elements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long arr[] = new long[n];
            long ans[] = new long[n];
            ans[0] = 1;
            arr[0] = sc.nextLong();
            int val = 2;
            for (int i = 1; i < n; i++) {
                arr[i] = sc.nextLong();

                if (i != 0) {
                    long diff = arr[i] - arr[i - 1];
                    int idx = i - (int) diff;
                    if (diff == i + 1) {
                        ans[i] = val++;
                    } else {
                        ans[i] = idx < 0 ? ans[i - 1] : ans[idx];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }

            System.out.println();
        }
    }
}