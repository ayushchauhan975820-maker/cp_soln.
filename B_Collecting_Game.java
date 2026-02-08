import java.util.*;

public class B_Collecting_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            long nums[] = new long[n];
            long arr[] = new long[n];
            long prefix[] = new long[n];
            HashMap<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                nums[i] = (long) sc.nextInt();
                arr[i] = nums[i];
            }

            Arrays.sort(arr);
            for (int i = 0; i < n; i++) {
                if (i == 0)
                    prefix[i] = arr[i];
                else
                    prefix[i] = prefix[i - 1] + arr[i];
            }

            for (int i = n - 1; i >= 0; i--) {
                if (i == n - 1) {
                    map.put(arr[i], n - 1);
                } else {
                    if (prefix[i] >= arr[i + 1]) {
                        int val = map.get(arr[i + 1]);
                        map.put(arr[i], val);
                    } else {
                        map.put(arr[i], i);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                int ans = map.get(nums[i]);
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }
}