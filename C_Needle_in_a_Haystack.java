import java.util.*;

public class C_Needle_in_a_Haystack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            String s = sc.next();
            String t = sc.next();

            HashMap<Character, Integer> map = new HashMap<>();
            TreeMap<Character, Integer> c = new TreeMap<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            for (int i = 0; i < t.length(); i++) {
                char ch = t.charAt(i);
                c.put(ch, c.getOrDefault(ch, 0) + 1);
            }
            boolean isValid = true;
            for (char ch : map.keySet()) {
                if ((!c.containsKey(ch)) || c.get(ch) < map.get(ch)) {
                    isValid = false;
                    break;
                }
            }

            if (!isValid) {
                System.out.println("Impossible");
                continue;
            }

            for (char ch : c.keySet()) {
                int inc = c.get(ch);
                int inm = (map.containsKey(ch)) ? map.get(ch) : 0;

                for (int i = 0; i < inc - inm; i++) {
                    sb.append(ch);
                }
            }

            int arr[] = new int[s.length()];
            int last = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (i < last)
                    continue;
                if (last >= sb.length()) {
                    arr[i] = sb.length();
                    continue;
                }
                while (sb.charAt(last) < ch) {
                    last++;
                }
                arr[i] = last;
            }
            StringBuilder n = new StringBuilder();
            int sbi = sb.length() - 1;
            int si = s.length() - 1;

            while (sbi >= 0 && si >= 0) {
                if (sbi > arr[si]) {
                    n.append(sb.charAt(sbi--));
                } else {
                    n.append(s.charAt(arr[si--]));
                }
            }

            while (sbi >= 0) {
                n.append(sb.charAt(sbi--));
            }
            while (si >= 0) {
                n.append(s.charAt(arr[si--]));
            }

            System.out.println(n.reverse());
        }
    }

    /*
     
    */

}