import java.util.*;

public class E_Romantic_Glasses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            long prefix[] = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

                if (i == 0 || i == 1)
                    prefix[i] = a[i];
                else
                    prefix[i] = prefix[i - 2] + a[i];
            }
            HashSet<Long> evn = new HashSet<>();
            HashSet<Long> odd = new HashSet<>();
            long diff[] = new long[n];
            diff[0] = prefix[0];
            evn.add(diff[0]);
            boolean valid = false;
            for (int i = 1; i < n; i++) {
                long sub = prefix[i] - prefix[i - 1];

                if (sub == 0) {
                    valid = true;
                    break;
                }
                if (i % 2 == 0) {
                    if (evn.contains(sub) || odd.contains(-sub)) {
                        valid = true;
                        break;
                    }
                    evn.add(sub);
                } else {
                    if (evn.contains(-sub) || odd.contains(sub)) {
                        valid = true;
                        break;
                    }
                    odd.add(sub);
                }
            }

            if (valid)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    /*
    
     */
}