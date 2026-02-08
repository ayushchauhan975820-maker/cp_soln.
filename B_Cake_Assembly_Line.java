import java.util.*;

public class B_Cake_Assembly_Line {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int w = sc.nextInt();
            int h = sc.nextInt();

            int cakes[] = new int[n];
            int dispensers[] = new int[n];

            for (int i = 0; i < n; i++) {
                cakes[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                dispensers[i] = sc.nextInt();
            }

            long min = Long.MIN_VALUE;
            long max = Long.MAX_VALUE;
            boolean valid = true;
            for (int i = 0; i < n; i++) {
                long left = (long) dispensers[i] + h - w - cakes[i];
                long right = (long) dispensers[i] - h + w - cakes[i];
                min = Math.max(min, left);
                max = Math.min(max, right);

                if (min > max) {
                    valid = false;
                    break;
                }
            }

            if (valid)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}