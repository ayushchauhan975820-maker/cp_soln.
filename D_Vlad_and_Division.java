import java.util.*;

public class D_Vlad_and_Division {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int count = 0;
            HashMap<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                long num = sc.nextLong();

                // build reverse num
                long rev = 0;
                for (int j = 0; j < 31; j++) {
                    long ch = (num & (1 << j));

                    if (ch == 0) {
                        rev = (rev | (1 << j));
                    }
                }

                if (map.containsKey(rev)) {
                    count++;
                    int val = map.get(rev);
                    if (val == 1)
                        map.remove(rev);
                    else
                        map.put(rev, val - 1);
                } else {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }

            for (int c : map.values()) {
                count += c;
            }

            System.out.println(count);
        }
    }
}