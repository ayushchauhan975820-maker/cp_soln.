import java.util.*;

public class C_Ultimate_Value {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n + 1];
            long sum = 0;
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextLong();
                if (i % 2 == 1) {
                    sum += a[i];
                } else {
                    sum -= a[i];
                }
            }
            long NEG = Long.MIN_VALUE / 4;

            long bestOdd = NEG;
            long bestEven = NEG;

            long mxg = Long.MIN_VALUE;

            for (int i = n; i >= 1; i--) {

                if ((i & 1) == 1) {
                    if (bestEven != NEG) {
                        mxg = Math.max(mxg, bestEven - (2L * a[i] + i));
                    }
                } else {
                    if (bestOdd != NEG) {
                        mxg = Math.max(mxg, bestOdd - (i - 2L * a[i]));
                    }
                }

                if ((i & 1) == 1) {
                    bestOdd = Math.max(bestOdd, i - 2L * a[i]);
                } else {
                    bestEven = Math.max(bestEven, 2L * a[i] + i);
                }
            }
            long max = Math.max(sum, sum + mxg);
            max = Math.max(max, sum + ((n & 1) == 0 ? n - 1 : n) - 1);
            System.out.println(max);
        }
    }
}

/*
 * a1 a2 a3 a4 a5
 * odd -> for max swap value 2a4 - 2a1 - (4 - 1) 2a2 - 2a1 - (2 - 1)
 * (2a4 - 4) - (2a1 - 1)
 * even -> 2a2 - 2a3 - (3 - 2)
 * 2a2 + 2 - (2a3 + 3)
 * 
 * 
 */