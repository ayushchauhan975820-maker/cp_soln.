import java.util.*;

public class B_Tenzing_and_Books {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int kn = 0;
            for (int j = 0; j < 3; j++) {
                boolean cnR = true;
                for (int i = 0; i < n; i++) {
                    int a = sc.nextInt();

                    if (cnR) {
                        if ((a | x) == x)
                            kn = kn | a;
                        else
                            cnR = false;
                    }
                }
            }

            if (kn == x)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}