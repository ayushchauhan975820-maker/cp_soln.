import java.util.*;

public class C_Permutation_Operations {
    public static class Pair {
        int idx;
        int diff;

        public Pair(int idx, int diff) {
            this.idx = idx;
            this.diff = diff;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.diff - b.diff);
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

                int diff = (i == 0) ? a[i] : a[i] - a[i - 1];

                if (diff < 0) {
                    pq.offer(new Pair(i + 1, Math.abs(diff)));
                }
            }

            for (int i = 1; i <= n; i++) {
                if (pq.isEmpty()) {
                    System.out.print(1 + " ");
                    continue;
                }

                Pair cur = pq.peek();
                if (i >= cur.diff) {
                    System.out.print(cur.idx + " ");
                    pq.poll();
                } else {
                    System.out.print(1 + " ");
                }
            }
            System.out.println();
        }
    }

    /*
     * try to make it increasing
     * 
     * if(diff is pos pick last pos - try to remove last difficulty)
     * pick first inversion from last that is possible i.e. sum of all n no must be
     * greater than diff
     */
}