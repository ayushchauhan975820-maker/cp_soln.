import java.util.*;

public class D_1709 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            ArrayList<int[]> list = new ArrayList<>();
            HashSet<Integer> ina = new HashSet<>();
            HashSet<Integer> inb = new HashSet<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] > n) {
                    ina.add(i);
                }
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
                if (b[i] <= n) {
                    inb.add(i);
                }
            }

            for (int idx : inb) {
                if (ina.contains(idx)) {
                    ina.remove(idx);
                } else {
                    // swap with some
                    int id = 0;
                    for (int fidx : ina) {
                        id = fidx;
                        break;
                    }

                    // swap with this
                    int temp = a[id];
                    a[id] = a[idx];
                    a[idx] = a[id];
                    ina.remove(id);
                    list.add(new int[] { id + 1, idx + 1 });
                }
                swap(a, b, idx);
                // inb.remove(idx);
                list.add(new int[] { idx + 1, idx + 1 });
            }

            // sort a and b
            sort(a, list);
            sort(b, list);
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
            }
        }

    }

    public static void swap(int a[], int b[], int idx) {
        int temp = a[idx];
        a[idx] = b[idx];
        b[idx] = temp;
    }

    public static void sort(int arr[], ArrayList<int[]> list) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
                list.add(new int[] { i + 1, minIdx + 1 });
            }
        }
    }

    /*
        
    */

}