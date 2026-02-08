import java.util.*;

public class B_Bowling_Frame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int w = sc.nextInt();
            int b = sc.nextInt();
            int count = 0;

            int l = 0;
            int r = (int) (1e8);

            while (l <= r) {
                int mid = l + (r - l) / 2;
                boolean ch = isPos(w, b, mid);
                if (ch) {
                    count = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            System.out.println(count);
        }
    }

    public static boolean isPos(int w, int b, int k) {
        long total = w + b;
        if ((long) (k + 1) * k / 2 > total)
            return false;

        for (int i = k; i >= 1; i--) {
            if (w < i && b < i)
                return false;

            if (w > b) {
                w = w - i;
            } else {
                b = b - i;
            }
        }

        return true;
    }
}