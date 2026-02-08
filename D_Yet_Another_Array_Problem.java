import java.util.*;

public class D_Yet_Another_Array_Problem {
    public static int seive[] = new int[150];
    public static TreeSet<Integer> set = new TreeSet<>();

    public static void seive(int seive[], TreeSet<Integer> set) {
        int n = seive.length;
        for (int i = 2; i * i < n; i++) {
            if (seive[i] == 1)
                continue;
            for (int j = i * i; j < n; j += i) {
                seive[j] = 1;
            }
        }

        for (int i = 2; i < n; i++) {
            if (seive[i] == 0)
                set.add(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        seive(seive, set);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long a[] = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int x = 0;
                for (int p : set) {
                    if (a[i] % p != 0) {
                        x = p;
                        break;
                    }
                }

                min = Math.min(min, x);
            }

            System.out.println(min);
        }
    }

    /*
        
    */

}