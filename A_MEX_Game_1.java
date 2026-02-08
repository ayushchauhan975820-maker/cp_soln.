import java.util.*;

public class A_MEX_Game_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int a[] = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }

            int f = -1;
            int mex = 0;
            // find first and second non dup
            for (int i = 0; i < n + 1; i++) {
                if (map.containsKey(i)) {
                    int val = map.get(i);
                    if (val == 1) {
                        if (f == -1) {
                            f = i;
                        } else {
                            mex = i;
                            break;
                        }
                    }
                } else {
                    mex = i;
                    break;
                }
            }

            System.out.println(mex);
        }
    }

    /*
     * alice adds smallest -> then bob removes next and alice adds it if it exist
     * and if not it is ans
     * 
     * alice will add whose scarcity see face
     * 
     * 0 - y
     * she can add 0 at anytime 2 times rem
     * has to add first no thats has no dup and all the others b/w them must have a
     * dup
     * 
     * 0 1 1 2 add first no dup bob will remove first non dup add all the dup nos.
     * in b/w
     * 
     * 
     */
}