import java.util.*;

public class A_Qingshan_Loves_Strings_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    sum += 1;
                } else {
                    sum -= 1;
                }
            }

            if (sum != 0) {
                System.out.println(-1);
                continue;
            }

            Deque<Character> dq = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                dq.offerLast(s.charAt(i));
            }
            int i = 0;
            int cnt = 0;
            ArrayList<Integer> list = new ArrayList<>();
            while (dq.size() > 0) {
                char fst = dq.getFirst();
                char lst = dq.getLast();

                if (fst == '1' && lst == '1') {
                    list.add(i);
                    dq.removeLast();
                    dq.offerFirst('1');
                    i++;
                    cnt++;
                } else if (fst == '0' && lst == '0') {
                    list.add(dq.size() + i);
                    dq.removeFirst();
                    dq.offerLast('0');
                    cnt++;
                    i++;
                } else {
                    dq.removeFirst();
                    dq.removeLast();
                    i++;
                }
            }

            System.out.println(cnt);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
    }
}