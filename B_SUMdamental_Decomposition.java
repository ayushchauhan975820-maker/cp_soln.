import java.util.*;

public class B_SUMdamental_Decomposition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            // calc msb and lsb
            ArrayList<Integer> list = new ArrayList<>();
            int lsb = -1;

            for (int i = 0; i < 31; i++) {
                boolean unset = ((x & (1 << i)) == 0);
                if (unset && lsb == -1) {
                    lsb = i;
                }

                if (!unset)
                    list.add(i);
            }

            long sum = 0;
            if (list.size() == 0) {
                if (n == 1) {
                    sum = -1;
                } else if (n % 2 == 0) {
                    sum = n;
                } else {
                    int left = n - 2;
                    sum += 2 + 3 + left;
                }
            } else if (n <= list.size()) {
                int toCom = list.size() - n + 1;
                int idx = 0;
                int a = 0;
                while (idx < toCom) {
                    a = a | (1 << list.get(idx));
                    idx++;
                }
                sum += a;
                for (int i = idx; i < list.size(); i++) {
                    sum += (1 << list.get(i));
                }

            } else {
                if (list.size() == 1) {
                    sum += (1 << list.get(0));
                    int left = n - 1;
                    if (left % 2 != 0) {
                        sum += 2 * (1 << lsb);
                        left--;
                    }
                    sum += left;
                } else {
                    int left = n - list.size();
                    for (int i = 0; i < list.size(); i++) {
                        sum += (1 << list.get(i));
                    }
                    if (left % 2 != 0) {
                        sum++;
                    }
                    sum += left;
                }
            }

            System.out.println(sum);
        }
    }

    /*
        
    */

}