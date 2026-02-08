import java.util.*;

public class E_Interesting_Ratio {
    public static boolean[] sieve = new boolean[(int) (1e7 + 1)];
    public static ArrayList<Integer> prime = new ArrayList<>();

    public static void getPrime(boolean[] sieve) {
        int n = sieve.length;
        sieve[0] = true;
        sieve[1] = true;
        for (int i = 2; i * i < n; i++) {
            if (sieve[i])
                continue;

            for (int j = i * i; j < n; j += i) {
                sieve[j] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!sieve[i]) {
                prime.add(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        getPrime(sieve);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();

            long count = 0;
            for (long gcd = 1; 2 * gcd <= n; gcd++) {

                int idx = 0;
                while (idx < prime.size() && (long) gcd * prime.get(idx) <= n) {
                    count++;
                    idx++;
                }
            }

            System.out.println(count);
        }
    }

    /*
     * a and b always satisfy a.b/(gcd)2
     * 1.) every prime with 1
     * 2.) prime and its sq.
     * 3.) gcd and root of its pow in other then any prime mul. will give the result
     * 4.)
     * 
     * gcd1 = 1 = 1.p (1, 1.p)
     * gcd2 = 4 = 4.p (2, 2.p)
     * gcd3 = 9 = 9.p (3, 3.p)
     * gcd4 = 16 = 16.p (4, 4.p)
     * gcd7 = 49 = 49.p = (7, 7.p)
     * 
     */

}