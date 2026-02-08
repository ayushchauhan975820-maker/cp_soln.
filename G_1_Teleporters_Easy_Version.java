import java.util.*;

public class G_1_Teleporters_Easy_Version {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int coins = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt() + i + 1;
            }

            Arrays.sort(arr);
            int count = 0;
            int i = 0;
            while (i < n && coins >= arr[i]) {
                coins -= arr[i];
                i++;
                count++;
            }

            System.out.println(count);
        }
    }
}