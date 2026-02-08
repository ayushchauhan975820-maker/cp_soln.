import java.util.*;

public class C_Divisor_Chain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(x);
            for (int i = 0; i < 32; i++) {
                if ((x ^ (1 << i)) == 0)
                    break;

                if ((x & (1 << i)) != 0) {
                    x = x - (1 << i);
                    list.add(x);
                }
            }

            while (x != 1) {
                x = x / 2;
                list.add(x);
            }

            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    /*
     * powers of two
     */

}