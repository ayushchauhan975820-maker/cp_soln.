import java.util.*;

public class C_Make_it_Alternating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long mod = (long) 998244353;
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            long count = 1;
            long len = 0;
            long ans = 1;
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    count++;
                } else {
                    ans = (ans * count) % mod;
                    len += Math.max(0, count - 1);
                    count = 1;
                }
            }

            ans = (ans * count) % mod;
            len += Math.max(0, count - 1);

            for (int i = 1; i <= len; i++) {
                ans = (ans * i) % mod;
            }

            System.out.println(len + " " + ans);
        }
    }
}