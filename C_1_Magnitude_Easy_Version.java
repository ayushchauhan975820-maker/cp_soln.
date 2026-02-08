import java.util.*;

public class C_1_Magnitude_Easy_Version {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long a[] = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            // try blocking
            ArrayList<Long> list = new ArrayList<>();
            int i = 0;
            while (i < n) {
                boolean isPos = false;
                if (a[i] > 0)
                    isPos = true;

                int idx = i;
                long sum = 0;
                if (isPos) {
                    while (idx < n && a[idx] >= 0) {
                        sum += a[idx];
                        idx++;
                    }
                } else {
                    while (idx < n && a[idx] <= 0) {
                        sum += a[idx];
                        idx++;
                    }
                }

                list.add(sum);
                i = idx;
            }

            long total = 0;
            for (int idx = 0; idx < list.size(); idx++) {
                total = Math.abs(total + list.get(idx));
            }

            System.out.println(total);
        }
    }

    /*
     * - - + - - -ve +ve we have to sub atleast one
     */

}