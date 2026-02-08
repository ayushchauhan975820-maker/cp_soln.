import java.util.*;

public class E_Beautiful_Palindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(i + 1);
                set2.add(i + 1);
            }

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                list.add(val);
                if (set.contains(val)) {
                    set.remove(val);
                }
            }

            for (int num : set) {
                if (k > 0) {
                    list.add(num);
                    k--;
                } else {
                    break;
                }
            }

            while (k > 0) {
                int val1 = list.get(list.size() - 1);
                int val2 = list.get(list.size() - 2);
                int val = 1;
                for (int num : set2) {
                    if (num != val1 && num != val2) {
                        val = num;
                        break;
                    }
                }
                list.add(val);
                k--;
            }

            for (int i = n; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}