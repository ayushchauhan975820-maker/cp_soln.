import java.util.*;

public class C_1_Adjust_The_Presentation_Easy_Version {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int q = sc.nextInt();

            int a[] = new int[n];
            int up[] = new int[m];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            for (int i = 0; i < m; i++)
                up[i] = sc.nextInt();

            HashSet<Integer> set = new HashSet<>();
            boolean valid = true;
            int idx = 0;
            for (int i = 0; i < m; i++) {
                boolean inA = false;

                if (idx < n && a[idx] == up[i]) {
                    inA = true;
                }

                if (inA) {
                    set.add(a[idx]);
                    idx++;
                } else {
                    if (!set.contains(up[i])) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid)
                System.out.println("YA");
            else
                System.out.println("TIDAK");
        }
    }

    /*
        
    */

}