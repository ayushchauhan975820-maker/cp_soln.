import java.util.*;

public class C_Make_It_Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            // for deletion
            int c = sc.nextInt();
            // for insetion
            int d = sc.nextInt();
            int a[] = new int[n];

            ArrayList<Integer> list = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            long sumDup = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (set.contains(a[i]))
                    sumDup += (long) c;
                else {
                    set.add(a[i]);
                    list.add(a[i]);
                }
            }

            Collections.sort(list);
            long min = (long) list.size() * c + (long) d;
            for (int i = 0; i < list.size(); i++) {
                long cost = d * (long) (list.get(i) - i - 1) + c * (long) (list.size() - i - 1);

                min = Math.min(min, cost);
            }

            min += sumDup;

            System.out.println(min);
        }

        /*
         * remove duplicates
         * cost
         * add nothing remove till valid
         * add low and remove upto that low
         * add(low + 2 low) and remove upto that low
         * .
         * .
         * add(all) remove none
         * 
         * at i no should be i + 1
         * if k - i + 1 give no of el missing and n - i + 1
         * cost = d * (k - i + 1) + c * (n - i + 1)
         */
    }
}