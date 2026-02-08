import java.util.*;

public class E_khba_Loves_to_Sleep {
    public static boolean ch(long a[], long k, long x, long dis) {
        int n = a.length;
        long count = 0;
        // check for first a[0] - dis
        count += Math.max(0, a[0] - dis);
        // check for last
        count += Math.max(0, x - a[n - 1] - dis);

        // check for all the pairs
        for (int i = 1; i < n; i++) {
            count += Math.max(0, (a[i] - dis) - (a[i - 1] + dis) - 1);
        }

        if (count >= k)
            return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long x = sc.nextLong();
            long to = k;
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            // sorting position vise
            Arrays.sort(a);

            long dis = 0;
            long l = 0;
            long r = x;
            while (l <= r) {
                long mid = l + (r - l) / 2;

                boolean ch = ch(a, to, x, mid);
                if (ch) {
                    dis = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            // place
            ArrayList<Long> list = new ArrayList<>();
            // starting pos
            for (long i = 0; i < a[0] - dis && k > 0; i++) {
                if (i + dis < a[0]) {
                    list.add(i);
                    k--;
                }
            }

            // middle pos
            for (int i = 1; i < n && k > 0; i++) {
                long st = a[i - 1];
                long end = a[i];

                for (long j = st + dis + 1; j < end - dis && k > 0; j++) {
                    list.add(j);
                    k--;
                }
            }

            // from last
            for (long i = a[n - 1] + dis + 1; i <= x && k > 0; i++) {
                list.add(i);
                k--;
            }

            HashSet<Long> placed_spots = new HashSet<>(list);
            long pos_filler = 0;

            // While we still need to place teleports (k > 0)
            while (k > 0 && pos_filler <= x) {
                if (!placed_spots.contains(pos_filler)) {
                    list.add(pos_filler);
                    placed_spots.add(pos_filler); // Mark as placed
                    k--;
                }
                pos_filler++;
            }

            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    /*
     * place k teleports such that position from each [ai] is maximized
     * 
     * no of pos left = x + 1 - n now have to choose furthest position from x
     * 
     * if n + k > x + 1 then place anywhere
     * 
     * maximize the minimum distance
     * 
     * if min distance binary search for min distance we can palce the items
     * 
     * if there are atleast k positions with that min dis that min dis can be taken
     */

}