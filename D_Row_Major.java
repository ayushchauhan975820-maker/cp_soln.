import java.util.*;

public class D_Row_Major {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    set.add(i);
                }
            }

            int min = 26;
            for (int i = 1; i < 26; i++) {
                if (!set.contains(i)) {
                    min = i;
                    break;
                }
            }

            char ch = 'a';
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i >= min) {
                    sb.append(sb.charAt(i - min));
                } else {
                    sb.append(ch);
                    ch++;
                }
            }

            System.out.println(sb);
        }
    }

    /*
     * build a string such that it is not a row major of any bad grid
     * minimize no of distinct characters in the string
     * 
     * nx1 -> row can be 1
     * find row no. and find min that is not it the array
     * 6 -> 1 2 3 t o m a t o
     */

}