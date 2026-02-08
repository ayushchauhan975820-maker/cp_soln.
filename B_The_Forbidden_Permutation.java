import java.util.*;

public class B_The_Forbidden_Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int intMax = Integer.MAX_VALUE;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            int p[] = new int[n];
            int a[] = new int[m];
            int pos[] = new int[m];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
                map.put(p[i], i + 1);
            }
            for (int i = 0; i < m; i++) {
                a[i] = sc.nextInt();
                pos[i] = map.get(a[i]);
            }

            int min = intMax;
            for (int i = 1; i < m; i++) {
                int f = pos[i - 1];
                int s = pos[i];

                if (f < s && s <= f + d) {
                    // for swapping condn. posa > posb
                    int swap = intMax;
                    swap = s - f;

                    // for + d condition. posa + d > posb
                    int add = intMax;

                    // s > f + d = d < s - f
                    int toAdd = d + f + 1 - s;

                    int availableSpace = (f - 1) + (n - s);
                    if (toAdd <= availableSpace) {
                        add = toAdd;
                    }

                    min = Math.min(min, Math.min(swap, add));
                } else {
                    min = 0;
                    break;
                }

            }
            if (min == intMax)
                min = 0;
            System.out.println(min);
        }
    }
}