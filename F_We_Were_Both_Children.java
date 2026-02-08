import java.util.*;

public class F_We_Were_Both_Children {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            // val, freq
            HashMap<Integer, Integer> map = new HashMap<>();
            int arr[] = new int[n + 1];
            for (int i = 0; i < n; i++) {
                long val = sc.nextLong();
                if (val > n)
                    continue;
                map.put((int) val, map.getOrDefault((int) val, 0) + 1);
            }

            int containsOne = 0;
            for (int num : map.keySet()) {
                if (num == 1)
                    containsOne = map.get(num);
                else {
                    int count = map.get(num);
                    for (int i = num; i <= n; i += num) {
                        arr[i] = arr[i] + count;
                    }
                }
            }

            int max = 0;
            for (int i = 1; i <= n; i++) {
                max = Math.max(max, arr[i]);
            }

            System.out.println(max + containsOne);
        }
    }
}