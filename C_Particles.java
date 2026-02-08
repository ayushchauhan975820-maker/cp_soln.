import java.util.*;

public class C_Particles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = (long) (-1e10);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            long alterOdd = min;
            long alterEven = min;

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (alterEven < 0) {
                        alterEven = Math.max(alterEven, a[i]);
                    } else {
                        alterEven += a[i] > 0 ? a[i] : 0;
                    }
                } else {
                    if (alterOdd < 0) {
                        alterOdd = Math.max(alterOdd, a[i]);
                    } else {
                        alterOdd += a[i] > 0 ? a[i] : 0;
                    }
                }

            }

            System.out.println(Math.max(alterEven, alterOdd));
        }

        /*
         * parity does not change i.e maximize alternaing sum
         */
    }
}