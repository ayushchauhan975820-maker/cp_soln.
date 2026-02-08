import java.util.*;

public class A_Beautiful_Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int arr[] = new int[n];
            int prefix[] = new int[n];
            int s = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                prefix[i] = s + arr[i];
                s = prefix[i];
            }

            int max = 0;
            for (int r = 0; r < n; r++) {
                for (int l = 0; l <= r; l++) {
                    int sum = 0;
                    if (l == 0) {
                        sum = prefix[r];
                    } else {
                        sum = prefix[r] - prefix[l - 1];
                    }
                    sum = sum / (r - l + 1);

                    max = Math.max(max, sum);
                }
            }

            System.out.println(max);
        }
    }
}