import java.util.*;

public class C_Doremy_s_City_Construction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                map.put(a, map.getOrDefault(a, 0) + 1);
            }

            int arr[] = new int[map.size()];
            int prefix[] = new int[map.size()];
            int idx = 0;
            for (int num : map.keySet()) {
                arr[idx] = num;
                prefix[idx] = (idx == 0) ? map.get(arr[idx]) : prefix[idx - 1] + map.get(arr[idx]);
                idx++;
            }

            if (map.size() == 1) {
                System.out.println(n / 2);
                continue;
            }

            long max = 1;
            for (int i = 0; i < prefix.length - 1; i++) {
                int left = prefix[i];
                int right = prefix[prefix.length - 1] - prefix[i];

                max = Math.max(max, (long) left * (long) right);
            }

            System.out.println(max);
        }
    }

    /*
     * trying making graph bipartite
     * 
     * i.e for every point you can select all the edges greater then it
     * if only one type then n/2
     */

}