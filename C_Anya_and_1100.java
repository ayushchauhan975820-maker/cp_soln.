import java.util.*;

public class C_Anya_and_1100 {
    public static int count(char arr[], int st, int en) {
        int count = 0;

        for (int i = st; i + 3 <= en; i++) {
            if (arr[i] == '1' && arr[i + 1] == '1' && arr[i + 2] == '0' && arr[i + 3] == '0') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            char arr[] = s.toCharArray();

            int q = sc.nextInt();

            int count = count(arr, 0, n - 1);

            for (int i = 0; i < q; i++) {
                int id = sc.nextInt();
                int idx = id - 1;
                int val = sc.nextInt();

                int left = Math.max(0, idx - 3);
                int right = Math.min(n - 1, idx + 3);

                int before = count(arr, left, right);
                arr[idx] = (char) ('0' + val);
                int after = count(arr, left, right);

                count += after - before;

                if (count > 0)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
}
