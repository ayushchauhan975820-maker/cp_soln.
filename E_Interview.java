import java.util.*;

public class E_Interview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int prefix[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (i == 0)
                    prefix[i] = a[i];
                else
                    prefix[i] = prefix[i - 1] + a[i];
            }

            int l = 1;
            int r = n;

            while (l < r) {
                int mid = l + (r - l) / 2;

                int total = prefix[mid - 1];
                int left = (l == 1) ? 0 : prefix[l - 2];

                System.out.print("? " + (mid - l + 1) + " ");
                for (int i = l; i <= mid; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
                System.out.flush();
                int sum = sc.nextInt();

                if ((total - left - sum) != 0) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            System.out.println("! " + l);
            System.out.println();
            System.out.flush();
        }
        /*
         * calc weight of piles of l - mid = pre[mid] - pre[l - 1]
         * ask for weight of l to mid = x
         * x - weight == 1
         * r = mid
         * else l = mid + 1
         * 
         * l == r
         */
    }
}
