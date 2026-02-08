import java.util.*;

public class B_Array_Recoloring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            if (k == 1) {
                // if first and last other max of first and last with mid
                int max = a[0] + a[n - 1];
                int grt = Math.max(a[0], a[n - 1]);
                for (int i = 1; i < n - 1; i++) {
                    max = Math.max(max, grt + a[i]);
                }

                System.out.println(max);
                continue;
            }

            int toPick = k + 1;

            long cost = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                pq.offer(a[i]);
            }

            while (toPick > 0) {
                cost += (long) pq.poll();
                toPick--;
            }

            System.out.println(cost);
        }
    }

    /*
        
    */

}