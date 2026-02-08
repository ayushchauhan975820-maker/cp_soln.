import java.util.*;

public class B_Beautiful_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            ArrayList<Integer> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    l.add(i + 1);
                }
            }

            System.out.println(l.size());
            for (int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i) + " ");
            }
            System.out.println();
        }
    }
}