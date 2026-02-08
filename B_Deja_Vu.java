import java.util.*;

public class B_Deja_Vu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int arr[] = new int[n];
            int query[] = new int[q];
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < q; i++) {
                query[i] = sc.nextInt();
            }

            for (int i = 0; i < q; i++) {
                int x = query[i];
                if (set.contains(x)) {
                    continue;
                }
                set.add(x);
                for (int j = 0; j < n; j++) {
                    int pow = (1 << x);
                    int toAdd = (1 << (x - 1));
                    if (arr[j] % pow == 0) {
                        arr[j] += toAdd;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}