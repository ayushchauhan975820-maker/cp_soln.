import java.util.*;

public class A_MEX_Partition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            boolean c[] = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                int idx = sc.nextInt();
                c[idx] = true;
            }
            int ans = 0;
            for (int i = 0; i < n + 1; i++) {
                if (!c[i]) {
                    ans = i;
                    break;
                }
            }

            System.out.println(ans);
        }
    }
}