import java.util.*;

public class A_Notelock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            int dis = -1;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (dis == -1 && s.charAt(i) == '1') {
                    count++;
                    dis = 0;
                    continue;
                }
                if (dis == -1)
                    continue;
                if (s.charAt(i) == '1') {
                    if (dis >= k - 1)
                        count++;
                    dis = 0;
                } else {
                    dis++;
                }
            }

            System.out.println(count);
        }
    }
}