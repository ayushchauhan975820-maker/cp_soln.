import java.util.*;

public class E_Easy_Assembly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long tc = sc.nextLong();
        ArrayList<Long> list = new ArrayList<>();

        long sp = 0;
        long com = 0;
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < tc; i++) {
            int bc = sc.nextInt();
            sp += bc - 1;
            for (int j = 0; j < bc; j++) {
                long a = sc.nextLong();
                // adding x y as y -> x
                if (j != 0) {
                    map.put(a, list.get(list.size() - 1));
                }
                list.add(a);
            }
        }
        com = list.size() - 1;
        Collections.sort(list);

        for (int i = 1; i < list.size(); i++) {
            long cur = list.get(i);
            long prev = list.get(i - 1);
            if (map.containsKey(cur)) {
                if (map.get(cur) == prev) {
                    sp--;
                    com--;
                }
            }
        }

        System.out.println(sp + " " + com);
    }

    /*
        
    */

}