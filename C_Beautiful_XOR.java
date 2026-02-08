import java.util.*;

public class C_Beautiful_XOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int msbA = 0;
            int msbB = 0;
            for (int i = 0; i < 32; i++) {
                if ((a & (1 << i)) != 0)
                    msbA = i;
                if ((b & (1 << i)) != 0)
                    msbB = i;
            }

            if (msbB > msbA) {
                System.out.println(-1);
                continue;
            }

            if (a == b) {
                System.out.println(0);
                continue;
            }
            ArrayList<Integer> list = new ArrayList<>();
            int st = Math.max(msbA, msbB);
            for (int i = 0; i <= st; i++) {
                int A = (a & (1 << i));
                int B = (b & (1 << i));

                if (B == 0 && A != 0) {
                    list.add((1 << i));
                } else if (A == 0 && B != 0) {
                    list.add(1 << i);
                }
            }

            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}