import java.util.*;

public class C_Hamiltonian_Wall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String r1 = sc.next();
            String r2 = sc.next();
            int pos = 0;
            boolean broken = false;
            for (int i = 0; i < n; i++) {
                int c1 = r1.charAt(i);
                int c2 = r2.charAt(i);

                if (pos == 0) {
                    if (c1 == 'B' && c2 != 'B') {
                        pos = 1;
                    }
                    if (c2 == 'B' && c1 != 'B') {
                        pos = 2;
                    }
                } else {
                    if (c1 == 'B' && c2 == 'B') {
                        pos = pos == 1 ? 2 : 1;
                    } else if (pos == 1) {
                        if (c2 == 'B') {
                            // System.out.println("NO");
                            broken = true;
                            break;
                        }
                    } else {
                        if (c1 == 'B') {
                            // System.out.println("NO");
                            broken = true;
                            break;
                        }
                    }
                }
            }
            if (broken)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}