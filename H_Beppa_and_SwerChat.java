import java.util.*;

public class H_Beppa_and_SwerChat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            int tw[] = new int[n];
            for (int i = 0; i < n; i++) {
                int idx = sc.nextInt();
                --idx;
                arr[idx] = i;
            }
            for (int i = 0; i < n; i++) {
                int idx = sc.nextInt();
                --idx;
                tw[i] = arr[idx];
            }

            int count = 1;
            for (int i = n - 2; i >= 0; i--) {
                if (tw[i] < tw[i + 1]) {
                    count++;
                } else {
                    break;
                }
            }

            System.out.println(n - count);
        }
    }
}