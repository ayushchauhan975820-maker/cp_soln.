import java.util.*;

public class C_Add_Divide_and_Floor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            Arrays.sort(arr);
            int tot = 0;
            ArrayList<Integer> list = new ArrayList<>();
            while (arr[0] != arr[n - 1]) {
                if (arr[0] % 2 == 0) {
                    arr[0] /= 2;
                    arr[n - 1] /= 2;
                    list.add(0);
                } else {
                    arr[0] = (arr[0] + 1) / 2;
                    arr[n - 1] = (arr[n - 1] + 1) / 2;
                    list.add(1);
                }
                tot++;
            }

            if (tot > n)
                System.out.println(tot);
            else {
                System.out.println(tot);
                if (tot == 0)
                    continue;
                for (int i = 0; i < tot; i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
            }
        }
    }

    /*
     * ai => (ai + x)/2
     * 
     * if x = ai then ai
     * x > ai + 1 then inc
     * x < ai then dec
     * 
     * 
     */

}