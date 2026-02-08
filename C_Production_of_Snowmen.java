import java.util.*;

public class C_Production_of_Snowmen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                int[] b = new int[n];
                int[] c = new int[n];

                for (int i = 0; i < n; i++)
                    a[i] = sc.nextInt();
                for (int i = 0; i < n; i++)
                    b[i] = sc.nextInt();
                for (int i = 0; i < n; i++)
                    c[i] = sc.nextInt();

                long AB = cvs(n, a, b);

                long BC = cvs(n, b, c);

                long ans = AB * BC * n;

                System.out.println(ans);
            }
        }
    }

    public static int cvs(int n, int[] f, int[] s) {
        int vc = 0;

        for (int shift = 0; shift < n; shift++) {
            boolean pos = true;
            for (int i = 0; i < n; i++) {
                if (f[i] >= s[(i + shift) % n]) {
                    pos = false;
                    break;
                }
            }

            if (pos) {
                vc++;
            }
        }
        return vc;
    }
}