import java.util.*;

public class B_New_Year_Cake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong(), b = sc.nextLong();
            System.out.println(Math.max(f(a, b), f(b, a)));
        }
    }

    static int f(long w, long d) {
        long cur = 1;
        int c = 0;
        boolean x = true;

        while (true) {
            if (x) {
                if (w < cur)
                    break;
                w -= cur;
            } else {
                if (d < cur)
                    break;
                d -= cur;
            }
            c++;
            cur <<= 1;
            x = !x;
        }
        return c;
    }
}
