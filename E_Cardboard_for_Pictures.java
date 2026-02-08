import java.util.*;

public class E_Cardboard_for_Pictures {
    public static int search(long c, long w, int sizes[]) {
        int n = sizes.length;
        for (int i = 0; i < n; i++) {
            long sum = (long) sizes[i] + 2 * w;
            long sq = sum * sum;

            if (sq <= c) {
                c = c - sq;
            } else {
                return -1;
            }
        }

        if (c == 0)
            return 0;
        else
            return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long c = sc.nextLong();

            int sizes[] = new int[n];
            for (int i = 0; i < n; i++) {
                sizes[i] = sc.nextInt();
            }

            long l = 1;
            long r = (long) (1e9);

            while (l <= r) {
                long mid = l + (r - l) / 2;

                int val = search(c, mid, sizes);

                if (val == 0) {
                    System.out.println(mid);
                    break;
                } else if (val == 1) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
    }
}