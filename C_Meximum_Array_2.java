import java.util.*;

public class C_Meximum_Array_2 {
    public static class Pair {
        int l;
        int r;

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int q = sc.nextInt();

            int mn[] = new int[n + 1];
            int mx[] = new int[n + 1];
            int a[] = new int[n + 1];
            Arrays.fill(a, 0);
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.l - y.l);
            for (int i = 0; i < q; i++) {
                int c = sc.nextInt();
                int l = sc.nextInt();
                int r = sc.nextInt();

                for (int j = l; j <= r; j++) {
                    if (c == 1) {
                        mn[j] = 1;
                    } else {
                        mx[j] = 1;
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                if (mn[i] == 1 && mx[i] == 1) {
                    a[i] = k + 1;
                } else if (mx[i] == 1) {
                    a[i] = i % k;
                } else {
                    a[i] = k;
                }
            }

            for (int i = 1; i <= n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }

    /*
     * 1 -> min(al, ar) = k
     * 2 -> mex(al, ar) = k
     * 
     * 
     */

}