import java.util.*;

public class E_Anisphia_Wynn_Palettia_and_Good_Permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            ArrayList<Integer> b2 = new ArrayList<>();
            ArrayList<Integer> b3 = new ArrayList<>();
            ArrayList<Integer> br = new ArrayList<>();

            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0)
                    b2.add(i);
                else if (i % 3 == 0)
                    b3.add(i);
                else
                    br.add(i);
            }
            int i2 = 0;
            int i3 = 0;
            int ir = 0;
            while (ir <= br.size() - 1 && i2 <= b2.size() - 2) {
                ans.add(br.get(ir++));
                ans.add(b2.get(i2++));
                ans.add(b2.get(i2++));
            }
            while (ir <= br.size() - 1 && i3 <= b3.size() - 2) {
                ans.add(br.get(ir++));
                ans.add(b3.get(i3++));
                ans.add(b3.get(i3++));
            }
            while (i2 < b2.size()) {
                ans.add(b2.get(i2++));
            }
            while (i3 < b3.size()) {
                ans.add(b3.get(i3++));
            }
            while (ir < br.size()) {
                ans.add(br.get(ir++));
            }

            for (int i = 0; i < n; i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }

    /*
        
    */

}