import java.util.*;

public class D_Rae_Taylor_and_Trees_easy_version {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int p[] = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }

            int pre[] = new int[n];
            int suf[] = new int[n];
            for (int i = 0; i < n; i++) {
                pre[i] = (i == 0) ? p[i] : Math.min(pre[i - 1], p[i]);
            }
            for (int i = n - 1; i >= 0; i--) {
                suf[i] = (i == n - 1) ? p[i] : Math.max(suf[i + 1], p[i]);
            }

            boolean can = true;
            for (int i = 1; i < n - 1; i++) {
                int left = pre[i - 1];
                int right = suf[i + 1];

                boolean stol = (p[i] > left && left < right);
                boolean btor = (p[i] < right && left < right);
                boolean stor = (p[i] < right && left < p[i]);

                if (!(stol || btor || stor)) {
                    can = false;
                    break;
                }
            }

            if (p[0] == n || p[n - 1] == 1) {
                System.out.println("No");
                continue;
            }

            if (can)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    /*
        
    */

}