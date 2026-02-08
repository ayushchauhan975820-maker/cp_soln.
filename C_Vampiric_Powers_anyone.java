import java.util.*;

public class C_Vampiric_Powers_anyone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int vis[] = new int[256];
            int ans = 0;
            for (int i = 1; i <= 255; i++) {
                int xor = 0;
                for (int j = 0; j < n; j++) {
                    xor = xor ^ a[j];
                    vis[xor]++;

                    if (vis[i] > 0 || vis[xor ^ i] > 0) {
                        ans = Math.max(ans, i);
                    }
                }
            }

            System.out.println(ans);
        }
    }

    /*
     * xor can not have greater msb than msb of max
     * 
     * try prefix xor and check for every starting idx
     * 
     * i = xor ^ x
     * 
     * i ^ xor = x
     * 
     * 
     */

}