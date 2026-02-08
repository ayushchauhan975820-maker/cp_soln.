import java.util.Scanner;

public class B_Optimal_Shifts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int count = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0')
                    count++;
                else
                    count = 0;
                max = Math.max(max, count);
            }

            int ar = 0;

            int idx = 0;
            while (idx < n && s.charAt(idx) == '0') {
                ar++;
                idx++;
            }

            idx = n - 1;
            while (idx >= 0 && s.charAt(idx) == '0') {
                ar++;
                idx--;
            }

            if (ar > n)
                ar = n;

            max = Math.max(ar, max);

            System.out.println(max);
        }

        sc.close();
    }
}