import java.util.*;

public class B_Transfusion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int nums[] = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            long sumEven = 0;
            int evenCount = 0;
            for (int i = 0; i < n; i = i + 2) {
                sumEven += (long) nums[i];
                evenCount++;
            }

            long sumOdd = 0;
            int oddCount = 0;
            for (int i = 1; i < n; i = i + 2) {
                sumOdd += (long) nums[i];
                oddCount++;
            }

            long even = sumEven / (long) evenCount;
            long odd = sumOdd / (long) oddCount;
            if ((sumEven % evenCount != 0) || (sumOdd % oddCount != 0) || (even != odd)) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}