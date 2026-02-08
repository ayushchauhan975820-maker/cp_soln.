import java.util.*;

public class E_2_Game_with_Marbles_Hard_Version {
    public static class Pair {
        int idx;
        long ai;
        long bi;

        public Pair(int idx, long ai, long bi) {
            this.idx = idx;
            this.ai = ai;
            this.bi = bi;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                b[j] = sc.nextInt();
            }
            PriorityQueue<Pair> pq = new PriorityQueue<>((Pair x, Pair y) -> {
                return Long.compare((y.ai + y.bi), (x.ai + x.bi));
            });
            for (int i = 0; i < n; i++) {
                pq.offer(new Pair(i, (long) a[i], (long) b[i]));
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                Pair cur = pq.poll();
                if (i % 2 == 0) {
                    ans = ans + cur.ai - 1;
                } else {
                    ans = ans - cur.bi + 1;
                }
            }
            System.out.println(ans);
        }
    }
}