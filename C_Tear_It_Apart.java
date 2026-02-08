import java.util.*;

public class C_Tear_It_Apart {
    public static int val(int num) {
        for (int i = 30; i >= 0; i--) {
            if ((num & (1 << i)) != 0) {
                return i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();

            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(s.charAt(i));
            }
            int min = (n + 1) / 2;
            for (char ch : set) {
                int max = 0;
                int len = 0;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == ch) {
                        len = 0;
                    } else {
                        len++;
                    }

                    max = Math.max(max, len);
                }

                int ops = val(max);
                min = Math.min(ops, min);
            }

            System.out.println(min);
        }
    }
}