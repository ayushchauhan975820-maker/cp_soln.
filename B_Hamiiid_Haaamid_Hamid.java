import java.util.*;

public class B_Hamiiid_Haaamid_Hamid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            // 1 based
            int pos = sc.nextInt();

            String s = sc.next();
            // check both side
            // if on left wall is add move to the rigth closest wall
            int lc = pos - 1;
            int rc = pos + 1;

            while (lc >= 1 && s.charAt(lc - 1) != '#') {
                lc--;
            }

            while (rc <= n && s.charAt(rc - 1) != '#') {
                rc++;
            }

            // // min for lc i.e wall is added to the right
            // int lMin = (lc == 0) ? 1 : lc + 1;

            // // min for rc i.e wall is added to the left
            // int rMin = (rc == n + 1) ? 1 : n - pos - rc;

            int L = pos - lc;
            int R = rc - pos;

            // Option 1: Don't add a wall
            int max_val = Math.min(L, R);

            // Option 2: Try to add a wall to the left
            int w_left = -1;
            // Find the *first* '.' in (lc, pos)
            for (int i = lc + 1; i < pos; i++) {
                if (s.charAt(i - 1) == '.') {
                    w_left = i;
                    break;
                }
            }

            if (w_left != -1) {
                // Calculate value if we place wall at w_left
                int val_option_2 = Math.min(pos - w_left, R);
                max_val = Math.max(max_val, val_option_2);
            }

            // Option 3: Try to add a wall to the right
            int w_right = -1;
            // Find the *last* '.' in (pos, rc)
            for (int i = rc - 1; i > pos; i--) {
                if (s.charAt(i - 1) == '.') {
                    w_right = i;
                    break;
                }
            }

            if (w_right != -1) {
                // Calculate value if we place wall at w_right
                int val_option_3 = Math.min(L, w_right - pos);
                max_val = Math.max(max_val, val_option_3);
            }

            System.out.println(max_val);
        }
    }

    /*
        
    */

}