import java.util.*;

public class C_Rabbits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

        }
    }

    /*
     * you can't defend a pot
     * -> is this pot secure
     * one it is surrounded by both one or no rab attacking it
     * 
     * t -> right
     * 
     * odd zeroes not true 1010101
     * 11 000 10101 0
     * 
     * 
     * 
     * void solve(){
     * int N;
     * cin >> N;
     * string S;
     * cin >> S;
     * for (int l = 0, r = 1; l < N; l = r, r = l + 1){
     * while (r != N && S[r - 1] != S[r]) r++;
     * // cout << l << " " << r << endl;
     * if (S[l] == '1' && (r - l) % 4 == 3){
     * cout << "NO\n";
     * return;
     * }
     * }
     * cout << "YES\n";
     * }
     * 
     * 
     */

}