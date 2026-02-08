import java.util.*;

public class C_Largest_Subsequence {
    public static class Pair {
        char ch;
        int idx;

        public Pair(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            char s[] = (sc.next()).toCharArray();
            Stack<Pair> st = new Stack<>();
            for (int i = 0; i < n; i++) {
                char ch = s[i];
                while (!st.isEmpty() && (st.peek().ch < ch)) {
                    st.pop();
                }
                st.push(new Pair(ch, i));
            }

            int ops = 0;
            ArrayList<Character> list = new ArrayList<>();
            ArrayList<Integer> idx = new ArrayList<>();
            while (!st.isEmpty()) {
                if (st.peek().ch != st.firstElement().ch) {
                    ops++;
                }
                Pair cur = st.pop();
                list.add(cur.ch);
                idx.add(cur.idx);
            }
            for (int i = 0; i < list.size(); i++) {
                char ch = list.get(i);
                int id = idx.get(list.size() - 1 - i);
                s[id] = ch;
            }

            for (int i = 1; i < n; i++) {
                if (s[i - 1] > s[i]) {
                    ops = -1;
                    break;
                }
            }

            System.out.println(ops);
        }
    }

    /*
        
    */

}