import java.util.*;

public class C_Insert_Zero_and_Invert_Prefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            if (a[n - 1] == 1) {
                System.out.println("NO");
                continue;
            } else {
                System.out.println("YES");
            }

            ArrayList<Integer> list = new ArrayList<>();
            int i = 0;
            while (i < n) {
                int count = 0;
                while (i < n && a[i] == 1) {
                    count++;
                    i++;
                }

                list.add(count);
                i++;
            }

            for (int k = list.size() - 1; k >= 0; k--) {
                int oc = list.get(k);
                for (int j = 0; j < oc; j++) {
                    System.out.print(0 + " ");
                }
                System.out.print(oc + " ");
            }
            System.out.println();
        }
    }

    /*
     * 0 is inserted and len of sequence will be n
     * i insert 0 at p + 1 and invert rest of the sequence
     * will try from last
     * prefix[i]
     */
}