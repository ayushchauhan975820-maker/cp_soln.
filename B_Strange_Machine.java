import java.util.*;

public class B_Strange_Machine {
    public static class Pair {
        char type;
        int num;

        public Pair(char type, int num) {
            this.type = type;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();

            String s = sc.next();
            int ca = 0;
            ArrayList<Pair> list = new ArrayList<>();
            int i = 0;
            for (int k = 0; k < n; k++) {
                if (s.charAt(k) == 'A')
                    ca++;
            }
            while (i < n) {
                char ch = s.charAt(i);
                int j = i;
                int count = 0;
                while (j < n && s.charAt(j) == ch) {
                    count++;
                    j++;
                }
                i = j;
                list.add(new Pair(ch, count));
            }

            for (int k = 0; k < q; k++) {
                int a = sc.nextInt();

                if (ca == n)
                    System.out.println(a);
                else {

                    int count = 0;
                    int j = 0;
                    while (a > 0) {
                        int idx = j % list.size();
                        j++;

                        Pair curr = list.get(idx);
                        char ch = curr.type;
                        int num = curr.num;

                        if (ch == 'A') {
                            int ops = Math.min(a, num);
                            a = a - ops;
                            count += ops;
                        } else {
                            int ops_needed = (int) (Math.log(a) / Math.log(2)) + 1;
                            int ops = Math.min(ops_needed, num);
                            a = a / (1 << ops);
                            count += ops;
                        }
                    }

                    System.out.println(count);
                }
            }

            // Brute force

            // for (int i = 0; i < q; i++) {
            // int a = sc.nextInt();

            // if (ca == n) {
            // System.out.println(a);
            // } else {
            // int count = 0;
            // int j = 0;
            // while (a > 0) {
            // int idx = j % n;

            // if (s.charAt(idx) == 'A') {
            // a--;
            // } else {
            // a = a / 2;
            // }
            // count++;
            // j++;
            // }

            // System.out.println(count);
            // }
            // }

            // Pairing method
        }
    }

    /*
     * after dividing by num it will be num/2^x if 0 then
     */

}