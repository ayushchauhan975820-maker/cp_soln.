import java.util.*;

public class C_Kevin_and_Binary_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            int idx = 0;
            int maxC = -1;
            ArrayList<Character> list = new ArrayList<>();
            boolean ch = false;
            for (int i = 0; i < n; i++) {
                if (ch) {
                    if (s.charAt(i) == '0') {
                        list.add('1');
                    } else {
                        list.add('0');
                    }
                } else {
                    if (s.charAt(i) == '0') {
                        list.add('1');
                        ch = true;
                    }
                }
            }
            if (list.size() == 0)
                list.add('0');

            for (int i = 0; i <= n - list.size(); i++) {
                int cl = 0;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == s.charAt(i + j)) {
                        cl++;
                    } else {
                        break;
                    }
                }

                if (cl > maxC) {
                    maxC = cl;
                    idx = i;
                }
            }

            int l1 = 1;
            int l2 = n;
            int r1 = idx + 1;
            int r2 = idx + list.size();

            System.out.println(l1 + " " + l2 + " " + r1 + " " + r2);
        }
    }
}