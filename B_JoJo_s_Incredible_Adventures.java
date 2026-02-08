import java.util.*;

public class B_JoJo_s_Incredible_Adventures {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            int max = 0;
            int len = 0;
            for (int i = 0; i < 2 * n; i++) {
                int idx = i % n;
                if (s.charAt(idx) == '1') {
                    len++;
                } else {
                    len = 0;
                }

                max = Math.max(max, len);
            }
            max = Math.min(max, n);

            if (max == n) {
                System.out.println((long) n * (long) n);
                continue;
            }

            int half = (max + 1) / 2;
            System.out.println((long) half * (long) (max - half + 1));
        }
    }
}