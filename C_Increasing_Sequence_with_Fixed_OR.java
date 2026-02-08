import java.util.*;

public class C_Increasing_Sequence_with_Fixed_OR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();

            List<Integer> list = new ArrayList<>();
            for (int i = 63; i >= 0; i--) {
                if ((n & (1L << i)) != 0) {
                    list.add(i);
                }
            }

            if (list.size() == 1) {
                System.out.println(1);
                System.out.println(n);
                continue;
            }

            int terms = list.size() + 1;
            System.out.println(terms);
            for (int i = 0; i < terms; i++) {
                long num = 0;
                for (int j = 0; j < list.size(); j++) {
                    int bit = list.get(j);

                    if (j == i)
                        continue;

                    num = (num | (1L << bit));

                }

                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    /*
        
    */

}