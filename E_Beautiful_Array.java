import java.util.*;

public class E_Beautiful_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mean = sc.nextInt();
        int median = sc.nextInt();

        if (mean == median) {
            System.out.println(1);
            System.out.println(mean);
        } else {
            int a = median;
            int b = median;
            int c = median;

            int left = mean - median;

            if (left > 0) {
                c = c + (3 * left);
            } else {
                a = a + (3 * left);
            }

            System.out.println(3);
            System.out.println(a + " " + b + " " + c);
        }
    }
}