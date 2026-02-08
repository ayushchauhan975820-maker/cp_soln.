import java.util.*;

public class B_XOR_Array {
    static final int SHIFT = 1 << 20; // > max n (2e5) and < 2^29

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            int[] a = new int[n + 1];
            int[] pref = new int[n + 1];

            pref[0] = 0;
            for (int i = 1; i < r; i++) {
                pref[i] = i;
                a[i] = pref[i] ^ pref[i - 1];
            }

            pref[r] = l - 1;
            a[r] = pref[r] ^ pref[r - 1];

            for (int i = r + 1; i <= n; i++) {
                pref[i] = SHIFT + i;
                a[i] = pref[i] ^ pref[i - 1];
            }

            for (int i = 1; i <= n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}