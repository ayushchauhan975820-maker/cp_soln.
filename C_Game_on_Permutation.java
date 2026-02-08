import java.util.*;

public class C_Game_on_Permutation {
    public static void pse(int arr[], int min[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            while (!st.isEmpty() && arr[st.peek()] >= cur) {
                st.pop();
            }

            min[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int p[] = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }
            int mn = n + 1;
            int gt = n + 1;
            int count = 0;
            for (int i = 0; i < n; i++) {
                int val = p[i];

                if (mn < val && val < gt) {
                    count++;
                    gt = val;
                }
                mn = Math.min(mn, val);
            }

            System.out.println(count);
        }
    }

    /*
     * no of starting idx i such that alice always win no matter bobs move
     * 
     * can move to left i from j if ai < aj
     * win if player can't make a move
     * 
     * if there is a winnig pos to the left lesser then current then alice will lose
     * if no winning pos then alice will win
     * 
     * 
     * 
     * 
     */

}