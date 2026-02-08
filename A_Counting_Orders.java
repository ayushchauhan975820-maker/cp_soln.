import java.util.*;

public class A_Counting_Orders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int mod = (int) (1e9 + 7);
            int a[] = new int[n];
            int b[] = new int[n];
            int ans[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                b[j] = sc.nextInt();
            }
            Arrays.sort(a);
            Arrays.sort(b);
            int r = n - 1;
            int count = 0;
            for (int i = n - 1; i >= 0; i--) {
                while (r >= 0 && a[r] > b[i]) {
                    r--;
                    count++;
                }

                ans[i] = count;
                count--;
            }

            long max = 1;
            for (int i = 0; i < n; i++) {
                max = (max * (long) ans[i]) % mod;
            }

            if (max <= 0)
                System.out.println(0);
            else
                System.out.println(max);
        }
    }
}