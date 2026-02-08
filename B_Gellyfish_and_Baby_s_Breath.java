import java.util.*;

public class B_Gellyfish_and_Baby_s_Breath {
    public static long mod = 998244353L;
    public static long[] sq = new long[(int) (1e5) + 1];

    public static void calc() {
        sq[0] = 1;
        for (int i = 1; i < sq.length; i++) {
            sq[i] = (2 * sq[i - 1]) % mod;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        calc();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int p[] = new int[n];
            int q[] = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                q[i] = sc.nextInt();
            }
            int maxp[] = new int[n];
            int maxq[] = new int[n];
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    maxp[i] = 0;
                    maxq[i] = 0;
                } else {
                    if (p[(int) maxp[i - 1]] > p[i]) {
                        maxp[i] = maxp[i - 1];
                    } else {
                        maxp[i] = i;
                    }

                    if (q[(int) maxq[i - 1]] > q[i]) {
                        maxq[i] = maxq[i - 1];
                    } else {
                        maxq[i] = i;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                int idx1 = maxp[i];
                int idx2 = maxq[i];
                long ans = 0;
                if (p[idx1] != q[idx2]) {
                    if (p[idx1] > q[idx2]) {
                        ans = (sq[p[idx1]] + sq[q[i - idx1]]) % mod;
                    } else {
                        ans = (sq[q[idx2]] + sq[p[i - idx2]]) % mod;
                    }
                } else {
                    ans = (sq[p[idx1]] + sq[Math.max(p[i - idx2], q[i - idx1])]) % mod;
                }

                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }

    /*
     * ri = j = 0 -> i max(2^pj + 2^qi - j)
     * 
     * what is happening is for every i consider max sum of symmetrical pairing
     * O(n) or log n -> order matter
     * 
     * it is maximized by pow of 2, so for wvery pow of 2 check
     */

}