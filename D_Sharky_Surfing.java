import java.util.*;

public class D_Sharky_Surfing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int L = sc.nextInt();

            long ip = 1;
            int count = 0;
            ArrayList<long[]> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                long l = sc.nextLong();
                long r = sc.nextLong();

                list.add(new long[] { l, r - l + 2 });
            }

            ArrayList<long[]> pups = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                long idx = sc.nextLong();
                long pow = sc.nextLong();

                pups.add(new long[] { idx, pow });
            }
            Collections.sort(pups, (a, b) -> Long.compare(a[0], b[0]));

            int idx = 0;
            boolean valid = true;
            PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                long st = list.get(i)[0];
                long dis = list.get(i)[1];

                while (idx < m && pups.get(idx)[0] <= st) {
                    pq.offer(pups.get(idx)[1]);
                    idx++;
                }

                while (!pq.isEmpty() && ip < dis) {
                    ip += pq.poll();
                    count++;
                }

                if (ip < dis) {
                    valid = false;
                    break;
                }
            }

            if (!valid)
                System.out.println(-1);
            else
                System.out.println(count);
        }
    }
}