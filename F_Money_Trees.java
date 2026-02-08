import java.util.*;

public class F_Money_Trees {
    public static boolean ch(int h[], int prefix[], int len, int k) {
        int n = h.length;
        int l = 0;
        for (int i = 0; i < n; i++) {

            if (i > 0 && h[i - 1] % h[i] != 0) {
                l = i;
            }

            if (i - l + 1 > len) {
                l++;
            }

            int sum = (l == 0) ? prefix[i] : prefix[i] - prefix[l - 1];
            if (i - l + 1 == len && sum <= k) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            int h[] = new int[n];
            int prefix[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (i == 0)
                    prefix[i] = a[i];
                else
                    prefix[i] = prefix[i - 1] + a[i];
            }
            for (int j = 0; j < n; j++) {
                h[j] = sc.nextInt();
            }

            // search
            int l = 1;
            int r = n;
            int ans = 0;
            while (l <= r) {
                int mid = l + (r - l) / 2;

                boolean valid = ch(h, prefix, mid, k);

                if (valid) {
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