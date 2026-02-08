import java.util.*;

public class C_Strongly_Composite {
    public static int seive[] = new int[(int) (1e7 + 1)];

    public static void calc(int[] seive) {
        int n = seive.length;
        int r = 2;
        for (int i = 2; i * i < n; i++) {
            r = i;
            if (seive[i] == 0) {
                seive[i] = i;
                for (int j = i * i; j < n; j += i) {
                    if (seive[j] == 0) {
                        seive[j] = i;
                    }
                }
            }
        }

        for (int i = r; i < n; i++) {
            if (seive[i] == 0) {
                seive[i] = i;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        calc(seive);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

                int num = a[i];
                while (num != 1) {
                    int val = seive[num];
                    num /= val;
                    map.put(val, map.getOrDefault(val, 0) + 1);
                }
            }

            boolean allOne = false;
            int count = 0;
            int rem = 0;
            for (int val : map.values()) {
                count += val / 2;
                rem += val % 2;
            }

            if (rem != 0) {
                int pairs = rem / 3;

                if (pairs == 0 && count == 0) {
                    allOne = true;
                } else {
                    count += pairs;
                }
            }

            if (allOne) {
                System.out.println(0);
                continue;
            } else {
                System.out.println(count);
            }
        }
    }
}