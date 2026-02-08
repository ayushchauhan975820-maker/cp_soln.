import java.util.*;

public class F_Rae_Taylor_and_Trees_hard_version {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int p[] = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }

            int pre[] = new int[n];
            int suf[] = new int[n];
            for (int i = 0; i < n; i++) {
                pre[i] = (i == 0) ? p[i] : Math.min(pre[i - 1], p[i]);
            }
            for (int i = n - 1; i >= 0; i--) {
                suf[i] = (i == n - 1) ? p[i] : Math.max(suf[i + 1], p[i]);
            }
            ArrayList<int[]> list = new ArrayList<>();
            boolean can = true;
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i < n - 1; i++) {
                int left = pre[i - 1];
                int right = suf[i + 1];

                boolean stol = (p[i] > left && left < right);
                boolean btor = (p[i] < right && left < right);
                boolean stor = (p[i] < right && left < p[i]);

                if (btor) {
                    if (!set.contains(p[i]) || !set.contains(right)) {
                        list.add(new int[] { right, p[i] });
                        set.add(p[i]);
                        set.add(right);
                    }
                    if (!set.contains(left) || !set.contains(right)) {
                        list.add(new int[] { right, left });
                        set.add(left);
                        set.add(right);
                    }
                } else if (stol) {
                    if (!set.contains(p[i]) || !set.contains(left)) {
                        list.add(new int[] { p[i], left });
                        set.add(p[i]);
                        set.add(left);
                    }
                    if (!set.contains(left) || !set.contains(right)) {
                        list.add(new int[] { right, left });
                        set.add(left);
                        set.add(right);
                    }
                } else if (stor) {
                    if (!set.contains(p[i]) || !set.contains(right)) {
                        list.add(new int[] { right, p[i] });
                        set.add(p[i]);
                        set.add(right);
                    }
                    if (!set.contains(p[i]) || !set.contains(left)) {
                        list.add(new int[] { p[i], left });
                        set.add(p[i]);
                        set.add(left);
                    }
                } else {
                    can = false;
                    break;
                }
            }

            if (n == 2) {
                if (p[0] == 1 && p[1] == 2) {
                    System.out.println("Yes");
                    System.out.println("1 2");
                    continue;
                }
            }

            if (p[0] == n || p[n - 1] == 1) {
                System.out.println("No");
                continue;
            }

            if (can) {
                System.out.println("Yes");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
                }
            } else
                System.out.println("No");
        }
    }

    /*
        
    */

}