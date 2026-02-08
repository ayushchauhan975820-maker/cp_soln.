import java.util.*;

public class B_Erase_First_or_Second_Letter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            HashSet<Character> set = new HashSet<>();
            if (n == 1) {
                System.out.println(1);
                continue;
            }
            set.add(s.charAt(0));
            set.add(s.charAt(1));
            int count = 1;
            for (int i = 2; i < n; i++) {
                count += set.size();

                set.add(s.charAt(i));
            }
            count += set.size();

            System.out.println(count);
        }
    }
}