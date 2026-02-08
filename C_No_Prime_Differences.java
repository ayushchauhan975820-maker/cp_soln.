import java.util.*;

public class C_No_Prime_Differences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
        }
    }

    /*
     * every no b/w 1 -> n*m must appear
     */
    public static int size = (int) (1e9);
    public static boolean seive[] = new boolean[size];

    public static void calc() {
        seive[1] = false;
        for (int i = 2; i * i <= size; i++) {
            if (!seive[i])
                continue;
            for (int j = i * i; j < size; j = j + i) {
                seive[j] = false;
            }
        }
    }

    public boolean completePrime(int num) {
        char s[] = Integer.toString(num).toCharArray();

        int val = 0;
        for (int i = 0; i < s.length; i++) {
            val = val * 10 + (s[i] - '0');
            if (!seive[val]) {
                return false;
            }
        }
        val = 0;
        for (int j = s.length - 1; j >= 0; j--) {
            val = (s[j] - '0') * 10 + val;
            if (!seive[val]) {
                return false;
            }
        }
        return true;
    }

}