import java.util.*;

public class C_XOR_factorization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            int k = sc.nextInt();
            long arr[] = new long[k];

            if ((k & 1) == 1) {
                for (int i = 0; i < k; i++) {
                    System.out.print(n + " ");
                }
                System.out.println();
                continue;
            }

            int left = 0;
            for (int i = 60; i >= 0; i--) {
                if ((n & (1L << i)) != 0) {
                    left = i;
                    break;
                }
            }

            int count = 0;
            for (int i = left; i >= 0; i--) {
                boolean set = ((n & (1L << i)) != 0);

                if (set) {
                    for (int j = 0; j < k; j++) {
                        if (j == Math.min(count, k - 1))
                            continue;
                        arr[j] |= (1L << i);
                    }
                } else {
                    int times = Math.min(k, count - (count % 2));
                    for (int j = 0; j < times; j++) {
                        arr[j] |= (1L << i);
                    }
                }

                if (set)
                    count++;
            }

            for (int i = 0; i < k; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}