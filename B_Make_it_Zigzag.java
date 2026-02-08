import java.util.*;

public class B_Make_it_Zigzag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] max = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();

                if (i == 0)
                    max[i] = arr[i];
                else
                    max[i] = Math.max(arr[i], max[i - 1]);
            }

            int count = 0;
            for (int i = 1; i < n; i += 2) {
                arr[i] = max[i];
                if (arr[i - 1] == arr[i]) {
                    arr[i - 1] -= 1;
                    count++;
                }

                if (i + 1 < n && arr[i + 1] >= arr[i]) {
                    int diff = arr[i + 1] - arr[i];
                    count += diff + 1;
                    arr[i + 1] = arr[i + 1] - (diff + 1);
                }

            }

            System.out.println(count);
        }
    }
}