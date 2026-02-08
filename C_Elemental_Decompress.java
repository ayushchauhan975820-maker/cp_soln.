import java.util.*;

public class C_Elemental_Decompress {
    public static int idx(ArrayList<Integer> list, int val) {
        int l = 0;
        int r = list.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (val == list.get(mid))
                return mid;
            else if (val > list.get(mid))
                l = mid + 1;
            else
                r = mid - 1;
        }

        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            int grid[][] = new int[2][n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            boolean valid = true;
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Integer> multi = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                if (!map.containsKey(i)) {
                    list.add(i);
                } else {
                    if (map.get(i) > 2) {
                        valid = false;
                        break;
                    } else if (map.get(i) == 2) {
                        multi.add(i);
                        set.add(i);
                    }
                }
            }
            if (!valid) {
                System.out.println("NO");
                continue;
            }
            for (int i = 0; i < n; i++) {
                int val = arr[i];
                int times = map.get(arr[i]);

                if (times == 2) {
                    grid[0][i] = val;
                    map.put(val, 1);
                } else {
                    grid[1][i] = val;
                }
            }

            for (int i = 0; i < n; i++) {
                int val1 = grid[0][i];
                int val2 = grid[1][i];
                if (val1 == 0) {
                    if (set.contains(val2)) {
                        int idx = idx(multi, val2);
                        grid[0][i] = list.get(idx);
                    } else {
                        grid[0][i] = val2;
                    }
                } else {
                    if (set.contains(val1)) {
                        int idx = idx(multi, val1);
                        grid[1][i] = list.get(idx);
                    } else {
                        grid[1][i] = val1;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                int val1 = grid[0][i];
                int val2 = grid[1][i];

                int max = Math.max(val1, val2);
                if (max != arr[i]) {
                    valid = false;
                    break;
                }
            }

            if (!valid) {
                System.out.println("NO");
                continue;
            } else {
                System.out.println("YES");
            }

            for (int i = 0; i < n; i++) {
                System.out.print(grid[0][i] + " ");
            }
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(grid[1][j] + " ");
            }
            System.out.println();
        }
    }
}