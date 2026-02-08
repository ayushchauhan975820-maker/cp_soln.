import java.util.*;

public class C_Odd_Process {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> evens = new ArrayList<>();
            ArrayList<Integer> odds = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if ((x & 1) == 0)
                    evens.add(x);
                else
                    odds.add(x);
            }

            evens.sort(Collections.reverseOrder());
            odds.sort(Collections.reverseOrder());

            int totalEven = evens.size();
            int totalOdd = odds.size();

            long[] prefE = new long[totalEven + 1];
            for (int i = 0; i < totalEven; i++) {
                prefE[i + 1] = prefE[i] + evens.get(i);
            }

            if (totalOdd == 0) {
                for (int k = 1; k <= n; k++)
                    out.append("0 ");
                out.append("\n");
                continue;
            }

            long maxOdd = odds.get(0);

            for (int k = 1; k <= n; k++) {
                int y = Math.max(1, k - totalEven);
                if (y % 2 == 0)
                    y++;

                if (y > k || y > totalOdd) {
                    out.append("0 ");
                } else {
                    int x = k - y;
                    long score = maxOdd + prefE[x];
                    out.append(score + " ");
                }
            }
            out.append("\n");
        }

        System.out.print(out);
        sc.close();
    }
}