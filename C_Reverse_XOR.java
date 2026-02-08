import java.util.*;

public class C_Reverse_XOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int bits[] = new int[32];
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) != 0) {
                    bits[i] = 1;
                }
            }
            if (n == 0) {
                System.out.println("YES");
                continue;
            }

            int l = 0;
            int r = 31;
            while (bits[l] != 1) {
                l++;
            }
            while (bits[r] != 1) {
                r--;
            }
            boolean valid = true;
            while (l < r) {
                if (bits[l] != bits[r]) {
                    valid = false;
                }
                l++;
                r--;
            }

            if (l == r && bits[l] == 1) {
                valid = false;
            }

            if (valid)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}