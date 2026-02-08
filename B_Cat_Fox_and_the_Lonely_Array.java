import java.util.*;

public class B_Cat_Fox_and_the_Lonely_Array {

    public static boolean ch(int arr[], int k, int count) {
        int n = arr.length;
        int l = 0;
        int mask = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 21; j++) {
                if ((arr[i] & (1 << j)) != 0) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
            }

            while (i - l + 1 > k) {
                for (int j = 0; j < 21; j++) {
                    if ((arr[l] & (1 << j)) != 0) {
                        int val = map.get(j);
                        if (val == 1)
                            map.remove(j);
                        else
                            map.put(j, val - 1);
                    }
                }
                l++;
            }

            if (i - l + 1 == k) {
                if (map.size() != count)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int a[] = new int[n];
            int mask = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

                mask = mask | a[i];
            }

            int count = 0;
            for (int j = 0; j < 21; j++) {
                if ((mask & (1 << j)) != 0) {
                    count++;
                }
            }

            int ans = 1;
            int l = 1;
            int r = n;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                boolean valid = ch(a, mid, count);

                if (valid) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            }

            System.out.println(ans);
        }
    }

    /*
        
    */

}