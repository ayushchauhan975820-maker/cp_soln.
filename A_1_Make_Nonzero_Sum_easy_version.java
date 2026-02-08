import java.util.*;

public class A_1_Make_Nonzero_Sum_easy_version {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            int pos = 0;
            int neg = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();

                if (arr[i] == 1)
                    pos++;
                else
                    neg++;
            }

            if (Math.abs(pos - neg) % 2 != 0) {
                System.out.println(-1);
                continue;
            }
            ArrayList<int[]> list = new ArrayList<>();

            for (int i = 1; i < n; i += 2) {
                if (arr[i] == arr[i - 1]) {
                    list.add(new int[] { i, i + 1 });
                } else {
                    list.add(new int[] { i, i });
                    list.add(new int[] { i + 1, i + 1 });
                }
            }

            if (n % 2 != 0) {
                list.add(new int[] { n, n });
            }
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
            }
        }
    }
}