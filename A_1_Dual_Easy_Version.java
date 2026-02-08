import java.util.*;

public class A_1_Dual_Easy_Version {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int min = Integer.MAX_VALUE;
            int minIdx = 0;
            int maxIdx = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] > max) {
                    max = a[i];
                    maxIdx = i;
                }
                if (a[i] <= min) {
                    min = a[i];
                    minIdx = i;
                }
            }
            ArrayList<int[]> list = new ArrayList<>();

            boolean negGrt = (min < 0 && Math.abs(min) > Math.abs(max));
            if (min == max) {
                System.out.println(0);
                continue;
            }
            if (negGrt) {
                // make everything neg
                for (int i = 0; i < n; i++) {
                    // if (i == minIdx)
                    // continue;
                    if (a[i] > 0) {
                        a[i] = a[i] + min;
                        list.add(new int[] { i + 1, minIdx + 1 });
                    }
                }

                if (minIdx != n - 1) {
                    a[n - 1] = a[n - 1] + min;
                    list.add(new int[] { n - 1 + 1, minIdx + 1 });
                }

                for (int i = n - 2; i >= 0; i--) {
                    list.add(new int[] { i + 1, i + 1 + 1 });
                }
            } else {
                // make everything neg
                for (int i = 0; i < n; i++) {
                    // if (i == maxIdx)
                    // continue;
                    if (a[i] < 0) {
                        a[i] = a[i] + max;
                        list.add(new int[] { i + 1, maxIdx + 1 });
                    }
                }

                if (maxIdx != 0) {
                    list.add(new int[] { 0 + 1, maxIdx + 1 });
                }

                for (int i = 1; i < n; i++) {
                    list.add(new int[] { i + 1, i - 1 + 1 });
                }
            }

            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                int arr[] = list.get(i);

                System.out.println(arr[0] + " " + arr[1]);
            }
        }
    }

    /*
     * atmost 50 ops to make non decreasing
     * 
     * can add aj to any ai
     * 
     * so values can increase if +ve is added and decrease if -ve is added
     * 
     * add from first to last
     * 
     * 
     * 
     */

}