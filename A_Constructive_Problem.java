import java.util.*;

public class A_Constructive_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            HashSet<Integer> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                set.add(arr[i]);
            }

            int mex = 0;
            while (set.contains(mex))
                mex++;

            int s = n;
            int e = -1;
            for (int i = 0; i < n; i++) {
                if (arr[i] == mex + 1) {
                    s = Math.min(s, i);
                    e = Math.max(e, i);
                }
            }
            if (s == n) {
                if (mex == n) {
                    System.out.println("No");
                } else {
                    System.out.println("Yes");
                }
                continue;
            }

            for (int i = s; i <= e; i++) {
                arr[i] = mex;
            }
            HashSet<Integer> ne = new HashSet<>();
            for (int i = 0; i < n; i++) {
                ne.add(arr[i]);
            }

            int newMex = 0;
            while (ne.contains(newMex))
                newMex++;

            if (newMex == mex + 1)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}