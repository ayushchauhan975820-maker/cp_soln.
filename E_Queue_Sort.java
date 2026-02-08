import java.util.*;

public class E_Queue_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int min = Integer.MAX_VALUE;
            int idx = n;
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] < min) {
                    min = a[i];
                    idx = i;
                }
            }

            boolean sorted = true;
            for (int i = idx + 1; i < n; i++) {
                if (a[i - 1] > a[i]) {
                    sorted = false;
                    break;
                }
            }

            if (!sorted)
                System.out.println(-1);
            else
                System.out.println(idx);
        }
    }
}