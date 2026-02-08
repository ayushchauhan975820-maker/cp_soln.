import java.util.*;

public class D_Divide_and_Equalize {
    public static int[] seive = new int[(int) (1e6 + 1)];

    public static void calc(int[] seive) {
        int n = seive.length;
        for (int i = 2; i * i < n; i++) {
            if (seive[i] != 0)
                continue;

            seive[i] = i;
            for (int j = i * i; j < n; j += i) {
                if (seive[j] == 0)
                    seive[j] = i;
            }
        }

        for (int i = 2; i < n; i++) {
            if (seive[i] == 0)
                seive[i] = i;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        calc(seive);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int num = a;
                while (num > 1) {
                    int val = seive[num];
                    int cnt = 0;
                    while (num % val == 0) {
                        cnt++;
                        num = num / val;
                    }
                    map.put(val, map.getOrDefault(val, 0) + cnt);
                }
            }
            boolean valid = true;
            for (int num : map.values()) {
                if (num % n != 0) {
                    valid = false;
                    break;
                }
            }

            if (valid)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    /*
     * since a/x and b*x takes one prime factoriation from a to b and we can do it
     * any no of times
     * that means if all sum of all prime fac individually is distributive over n
     * then it is possible
     */
}