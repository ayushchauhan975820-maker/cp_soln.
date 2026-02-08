import java.util.*;

public class A_Incremental_Path {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String s = sc.next();
            HashSet<Integer> set = new HashSet<>();
            TreeSet<Integer> ans = new TreeSet<>();
            for (int i = 0; i < m; i++) {
                int val = sc.nextInt();
                set.add(val);
                ans.add(val);
            }

            int st = 1;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'A') {
                    st++;
                    ans.add(st);
                } else {
                    int nw = st + 1;
                    while (true) {
                        if (!set.contains(nw)) {
                            break;
                        }
                        nw++;
                    }
                    ans.add(nw);
                    nw++;
                    while (true) {
                        if (!set.contains(nw)) {
                            break;
                        }
                        nw++;
                    }
                    st = nw;
                }
            }

            System.out.println(ans.size());
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}