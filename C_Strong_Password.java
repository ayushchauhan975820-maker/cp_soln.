import java.util.*;

public class C_Strong_Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String d = sc.next();
            int m = sc.nextInt();
            String l = sc.next();
            String r = sc.next();

            int n = d.length();

            int idx = 0;
            for (int i = 0; i < m; i++) {
                int li = l.charAt(i) - '0';
                int ri = r.charAt(i) - '0';
                int maxIdx = -1;

                for (int j = li; j <= ri; j++) {
                    int k = idx;
                    while (k < n && d.charAt(k) - '0' != j) {
                        k++;
                    }
                    maxIdx = Math.max(maxIdx, k);

                }
                idx = maxIdx + 1;
            }

            if (idx > n) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    /*
     * len - m (0 - 9)
     * each b/w [l - r]
     * 
     * 
     */

}