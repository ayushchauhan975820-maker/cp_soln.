import java.util.*;

public class C_Disappearing_Permutation {
    public static class DSU {
        public List<Integer> par = new ArrayList<>();
        public List<Integer> size = new ArrayList<>();;

        public DSU(int n) {
            for (int i = 0; i < n; i++) {
                this.par.add(i);
                this.size.add(1);
            }
        }

        public int findPar(int idx) {
            if (idx == par.get(idx)) {
                return idx;
            }
            int val = par.get(idx);
            int par = findPar(val);

            this.par.set(idx, par);

            return par;
        }

        public void union(int idx1, int idx2) {
            if (idx1 == idx2)
                return;
            int par1 = findPar(idx1);
            int par2 = findPar(idx2);

            if (par1 == par2)
                return;

            if (size.get(par1) >= size.get(par2)) {
                this.par.set(par2, par1);
                this.size.set(par1, size.get(par1) + size.get(par2));
            } else {
                this.par.set(par1, par2);
                this.size.set(par2, size.get(par1) + size.get(par2));
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int p[] = new int[n];
            int d[] = new int[n];
            DSU dsu = new DSU(n + 1);
            // prepare dsu already
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
                dsu.union(i + 1, p[i]);
            }
            for (int j = 0; j < n; j++) {
                d[j] = sc.nextInt();
            }
            ArrayList<Integer> list = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            int cur = 0;
            for (int i = 0; i < n; i++) {
                int par = dsu.findPar(d[i]);
                if (!set.contains(par)) {
                    int size = dsu.size.get(par);
                    set.add(par);

                    cur += size;
                }
                list.add(cur);
            }

            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    /*
     * // element that are on their idx
     * 1 2 3 -> removing these is +1 ops
     * 
     * can only replace i with i
     * 
     * elements that are misplaced
     * 
     * 
     */

}