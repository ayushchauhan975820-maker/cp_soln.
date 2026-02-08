import java.util.*;

public class C_Salyg_1_n_and_the_MEX_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int mex = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                set.add(val);
            }

            while (set.contains(mex))
                mex++;

            while (mex != -1) {
                System.out.println(mex);
                System.out.flush();

                int val = sc.nextInt();
                mex = val;
            }
        }
    }
}