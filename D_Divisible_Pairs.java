import java.util.*;

public class D_Divisible_Pairs {
    public static class Pair {
        long x;
        long y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long x = sc.nextLong();
            long y = sc.nextLong();

            long a[] = new long[n];
            HashMap<Pair, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            long count = 0;
            for (int i = 0; i < n; i++) {
                long num = a[i];
                long aix = num % x;
                long aixy = num % y;
                long ajx = (x - (num % x)) % x;
                Pair p = new Pair(ajx, aixy);
                Pair pt = new Pair(aix, aixy);
                if (map.containsKey(p)) {
                    count += map.get(p);
                }

                map.put(pt, map.getOrDefault(pt, 0) + 1);
            }

            System.out.println(count);
        }
    }

    /*
     * a b
     * (a + b)/x = k => (a + b) = kx
     * (a - b)/y = l => (a - b) = ly
     * 
     * a = kx - b
     * a = ly + b
     * 
     * kx - b = ly + b
     * kx - ly = 2b
     * 
     * b = (kx - ly)/2;
     * a = (kx + ly)/2;
     * 
     * a = x + y/2;
     * b = x - y/2;
     * 
     * if x and y are both even or odd then all will satisfy
     * if x is even and y is odd
     */

}