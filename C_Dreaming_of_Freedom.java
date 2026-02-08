import java.util.*;

public class C_Dreaming_of_Freedom {
    public static int seive[] = new int[(int) (1e7 + 1)];

    public static void calc(int[] seive) {
        int n = seive.length;
        int r = 2;
        for (int i = 2; i * i < n; i++) {
            r = i;
            if (seive[i] == 0) {
                seive[i] = i;
                for (int j = i * i; j < n; j += i) {
                    if (seive[j] == 0) {
                        seive[j] = i;
                    }
                }
            }
        }

        for (int i = r; i < n; i++) {
            if (seive[i] == 0) {
                seive[i] = i;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        calc(seive);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if (n == 1 || m == 1) {
                System.out.println("YES");
            } else if (n <= m) {
                System.out.println("NO");
            } else {
                if (seive[n] <= m)
                    System.out.println("NO");
                else
                    System.out.println("YES");
            }
        }
    }
}