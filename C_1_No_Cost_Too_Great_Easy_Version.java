import java.util.*;

public class C_1_No_Cost_Too_Great_Easy_Version {
    public static int[] seive = new int[(int) (1e7 + 1)];

    public static void fact() {
        int n = seive.length;
        seive[1] = 1;
        for (int i = 2; i * i < n; i++) {
            if (seive[i] != 0)
                continue;

            seive[i] = i;
            for (int j = i * i; j < n; j += i) {
                if (seive[j] == 0) {
                    seive[j] = i;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (seive[i] == 0)
                seive[i] = i;
        }
    }

    public static HashSet<Integer> getPrimeFactors(int x) {
        HashSet<Integer> primes = new HashSet<>();
        while (x > 1) {
            primes.add(seive[x]);
            x /= seive[x];
        }
        return primes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fact();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int a[] = new int[n];
            int b[] = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            boolean gcd = false;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = getPrimeFactors(a[i]);
                for (int prime : set) {
                    map.put(prime, map.getOrDefault(prime, 0) + 1);
                    if (map.get(prime) > 1)
                        gcd = true;
                }
            }

            boolean canMake = false;
            for (int i = 0; i < n; i++) {
                int val = a[i] + 1;

                HashSet<Integer> set = getPrimeFactors(val);
                for (int prime : set) {
                    if (map.containsKey(prime)) {
                        if ((map.get(prime) >= 2) || (map.get(prime) == 1 && (val - 1) % prime != 0)) {
                            canMake = true;
                            break;
                        }
                    }

                    if (canMake)
                        break;
                }
            }

            if (gcd)
                System.out.println(0);
            else if (canMake)
                System.out.println(1);
            else
                System.out.println(2);
        }
    }

    /*
     * no prime factor must be common
     * min cost to make even
     * 
     * min cost to acheive any no
     * 
     * costs can be 0, 1, 2
     * when no max
     * ways to make max
     */

}
