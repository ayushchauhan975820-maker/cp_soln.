import java.util.*;

public class D_Xmas_or_Hysteria {
    public static class Pair {
        long val;
        int idx;

        public Pair(long val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            if (n / 2 < m) {
                System.out.println(-1);
                continue;
            }

            ArrayList<Pair> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                l.add(new Pair(a[i], i + 1));
            }

            l.sort((x, y) -> Long.compare(x.val, y.val));
            ArrayList<long[]> ans = new ArrayList<>();
            if (m == 0) {
                long sum = 0;
                int len = l.size();
                long hp = l.get(len - 1).val;
                for (int i = 0; i < len; i++) {
                    sum += l.get(i).val;
                }
                sum -= hp;
                if (sum < hp) {
                    System.out.println(-1);
                    continue;
                }

                // rest logic
                int x = len - 2;
                while (x >= 0 && l.get(x).val < hp) {
                    ans.add(new long[] { l.get(x).idx, l.get(len - 1).idx });
                    hp -= l.get(x--).val;
                }
                for (int i = 0; i < x; i++) {
                    ans.add(new long[] { l.get(i).idx, l.get(i + 1).idx });
                }
                ans.add(new long[] { l.get(x).idx, l.get(len - 1).idx });
            } else {
                int pairs = n / m;
                int idx = 0;
                for (int i = 1; i <= m; i++) {
                    int st = idx;
                    int ed = (i == m) ? l.size() - 1 : idx + pairs - 1;
                    for (int j = st; j < ed; j++) {
                        if (j + 1 == ed) {
                            ans.add(new long[] { l.get(j + 1).idx, l.get(j).idx });
                        } else {
                            ans.add(new long[] { l.get(j).idx, l.get(j + 1).idx });
                        }
                    }
                    idx = ed + 1;
                }
            }
            System.out.println(ans.size());
            for (int i = 0; i < ans.size(); i++) {
                System.out.println(ans.get(i)[0] + " " + ans.get(i)[1]);
            }

        }
    }

    /*
     * 1 2 3 4 5
     * 
     * 10/3 3
     * 
     * 333 333 3333
     */

}