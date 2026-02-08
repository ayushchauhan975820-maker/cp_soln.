import java.util.*;

public class D_Bracket_Coloring {
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
            String s = sc.next();

            Stack<Pair> st = new Stack<>();
            int arr[] = new int[n];
            boolean both[] = new boolean[2];
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);

                if (!st.isEmpty() && ((ch == ')' && st.peek().ch == '('))) {
                    Pair top = st.pop();

                    arr[top.idx] = 2;
                    arr[i] = 2;
                    both[1] = true;
                } else if (!st.isEmpty() && ((ch == '(' && st.peek().ch == ')'))) {
                    Pair top = st.pop();

                    arr[top.idx] = 1;
                    arr[i] = 1;
                    both[0] = true;
                } else {
                    st.push(new Pair(ch, i));
                }
            }

            if (!st.isEmpty()) {
                System.out.println(-1);
            } else {
                if (both[0] && both[1]) {
                    System.out.println(2);
                } else {
                    System.out.println(1);
                }
                for (int i = 0; i < n; i++) {
                    if (!both[0] || !both[1]) {
                        System.out.print(1 + " ");
                    } else {
                        System.out.print(arr[i] + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    /*
     * impos if no of opening no equal to no of closing
     */

}