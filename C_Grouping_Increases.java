import java.util.*;

public class C_Grouping_Increases {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int ans = 0;
            int x = -1;
            int y = -1;
            for (int i = n - 1; i >= 0; i--) {
                int num = a[i];
                if (num < x && num < y) {
                    ans++;
                    if (x > y) {
                        x = num;
                    } else {
                        y = num;
                    }
                } else if (num < x) {
                    y = num;
                } else if (num < y) {
                    x = num;
                } else {
                    if (x > y) {
                        x = num;
                    } else {
                        y = num;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}