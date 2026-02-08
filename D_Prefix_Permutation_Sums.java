import java.util.*;

public class D_Prefix_Permutation_Sums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            long a[] = new long[n - 1];
            int num[] = new int[n + 1];
            long greater = 0;
            long dup = 0;
            long sum = ((long) n * (n + 1)) / 2;
            boolean broke = false;
            for (int i = 0; i < n - 1; i++) {
                a[i] = sc.nextLong();

                long val = 0;
                if (i == 0) {
                    val = a[i];
                } else {
                    val = a[i] - a[i - 1];
                }

                if (val > n) {
                    if (greater != 0) {
                        broke = true;
                    } else {
                        greater = val;
                    }
                } else {
                    if (num[(int) val] != 0) {
                        if (dup != 0) {
                            broke = true;
                        } else {
                            dup = val;
                        }
                    } else {
                        num[(int) val] = 1;
                        sum -= val;
                    }
                }

            }

            if (greater != 0 && dup != 0) {
                broke = true;
            } else if (greater != 0) {
                if (sum != greater)
                    broke = true;
            } else if (dup != 0) {
                if (sum != dup)
                    broke = true;
            } // else {
              // if (sum < n)
              // broke = false;
              // }

            if (broke)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }

    /*
     * a b c d
     * since a perfix sum is missing
     * 
     * a + 0 a + b b + c c + d
     * 
     * a + 0 a + b c + d
     * 
     * a b (c + d - a - b) if missing no is the sum of these two then permuttion
     * C1 : if any no is greater then n then missing no must be the sum of these
     * C2 : check for duplicate
     */
}