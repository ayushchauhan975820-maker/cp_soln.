import java.util.*;

public class C_2_Skibidus_and_Fanum_Tax_hard_version {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int a[] = new int[n];
            int b[] = new int[m];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            TreeMap<Long, Integer> map = new TreeMap<>();
            for (int j = 0; j < m; j++) {
                b[j] = sc.nextInt();
                map.put((long) b[j], map.getOrDefault((long) b[j], 0) + 1);
            }
            long val = map.lastKey();
            boolean valid = true;
            a[n - 1] = (int) Math.max(a[n - 1], val - a[n - 1]);
            for (int i = n - 2; i >= 0; i--) {

                long tofind = a[i] + a[i + 1];

                Long del = map.floorKey(tofind);
                if (del == null) {
                    if (a[i] > a[i + 1]) {
                        valid = false;
                        break;
                    }
                } else {
                    if (a[i] <= a[i + 1]) {
                        a[i] = Math.max(a[i], (int) (del - a[i]));
                    } else {
                        a[i] = (int) (del - a[i]);
                    }

                }
            }

            if (valid)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    /*
     * 
     * b - a[i] <= a[i + 1]
     * (b <= a[i + 1] - a[i])
     * 
     * 2 any no greater so
     * 
     * if(a[i] > a[i + 1]) => b - a[i] <= a[i + 1] = b <= a[i + 1] + a[i]
     */

}