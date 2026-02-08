import java.util.*;

public class A_Concatenation_of_Arrays {
    public static class Pair implements Comparable<Pair> {
        int f;
        int s;

        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }

        @Override
        public int compareTo(Pair pair) {
            int max1 = Math.max(this.f, this.s);
            int max2 = Math.max(pair.f, pair.s);
            int min1 = Math.min(this.f, this.s);
            int min2 = Math.min(pair.f, pair.s);
            if (max1 == max2)
                return Integer.compare(min1, min2);
            return Integer.compare(max1, max2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            PriorityQueue<Pair> pq = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                Pair cur = new Pair(a, b);
                pq.offer(cur);
            }

            while (!pq.isEmpty()) {
                Pair cur = pq.poll();

                System.out.print(cur.f + " " + cur.s + " ");
            }
            System.out.println();
        }
    }

    /*
     * (a, b) (c, d)
     * 
     * we want if (a > c and b > d) then then whoever has greater max will be in
     * last
     * 
     */

}