import java.util.*;

public class E_Blackslex_and_Girls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long x = sc.nextLong();
            long y = sc.nextLong();
            char a[] = sc.next().toCharArray();
            int p[] = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
                sum += (long) p[i];
            }
            if (sum > x + y) {
                System.out.println("No");
                continue;
            }

            long mindsh = 0;
            long mindfh = 0;
            int fh = 0;
            int sh = 0;
            for (int i = 0; i < n; i++) {
                int half = p[i] / 2;
                if (p[i] % 2 == 0) {
                    if (a[i] == 0) {
                        fh += half + 1;
                        sh += half - 1;
                        mindsh += half - 1;
                    } else {
                        sh += half + 1;
                        fh += half - 1;
                        mindfh += half - 1;
                    }
                } else {
                    if (a[i] == 0) {
                        fh += half + 1;
                        sh += half;
                        mindsh += half;
                    } else {
                        sh += half + 1;
                        fh += half;
                        mindfh += half;
                    }
                }
            }

            // if need to dec both
            if (fh > x && sh > y)
                System.out.println("NO");
            else if (fh > x && sh <= y) {
                long dif = fh - x;
                if (sh + dif > y || dif > mindfh)
                    System.out.println("NO");
                else
                    System.out.println("YES");
            } else if (fh <= x && sh > y) {
                long dif = sh - y;
                if (fh + dif > x || dif > mindsh)
                    System.out.println("NO");
                else
                    System.out.println("YES");
            } else {
                System.out.println("YES");
            }
        }
    }

    /*
     * into 2 arrays
     * ai + .. + an == x
     * bi + .. + bn == y
     * 
     * 𝑎𝑖 + 𝑏𝑖 ≥ 𝑝𝑖
     * si = 0 -> ai > bi
     * si = 1 -> ai < bi
     * 
     * odd -> half - 1 half + 1
     * even -> half half + 1
     * 
     * 2 1 2
     * 1 3 1
     * 
     * 1 1 1 0
     * 0 0 0 1
     * 
     * 2 2
     * 1 1
     * 
     * p ->
     * 
     * +1 pe0 +1
     * 
     * 
     */

}