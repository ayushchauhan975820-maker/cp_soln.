import java.util.*;

public class E_Adjacent_XOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            int px[] = new int[n];
            px[n - 1] = a[n - 1];
            for (int i = 0; i < n - 1; i++) {
                px[i] = a[i] ^ a[i + 1];
            }

            boolean valid = true;
            if (a[n - 1] != b[n - 1])
                valid = false;
            for (int i = 0; i < n - 1; i++) {
                if (b[i] != a[i] && b[i] != px[i] && (b[i] != (a[i] ^ b[i + 1]))) {
                    valid = false;
                    break;
                }
            }

            System.out.println(valid ? "YES" : "NO");
        }
    }

    /*
     * so ai ai+1
     * last cant be changed
     * 
     * a[i] ^
     * 
     */

}