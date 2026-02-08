import java.util.*;

public class C_Place_for_a_Selfie {
    public static class Parabola {
        int a;
        int b;
        int c;

        public Parabola(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            // no of line and parabola
            int n = sc.nextInt();
            int m = sc.nextInt();

            int slope[] = new int[n];
            Parabola para[] = new Parabola[m];

            for (int i = 0; i < n; i++) {
                slope[i] = sc.nextInt();
            }
            Arrays.sort(slope);
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                para[i] = new Parabola(a, b, c);
            }

            for (int i = 0; i < m; i++) {
                Parabola p = para[i];

                // find slopes
                int l = n;
                int r = -1;
                int s = 0;
                int e = n - 1;

                while (s <= e) {
                    int mid = s + (e - s) / 2;

                    if (slope[mid] < p.b) {
                        s = mid + 1;
                    } else {
                        l = mid;
                        e = mid - 1;
                    }
                }
                s = 0;
                e = n - 1;
                while (s <= e) {
                    int mid = s + (e - s) / 2;

                    if (slope[mid] < p.b) {
                        r = mid;
                        s = mid + 1;
                    } else {
                        e = mid - 1;
                    }
                }

                if (l < n && (((long) slope[l] - p.b) * ((long) slope[l] - p.b) < 4L * p.a * p.c)) {
                    System.out.println("YES");
                    System.out.println(slope[l]);
                    continue;
                }

                if (r >= 0 && (((long) slope[r] - p.b) * ((long) slope[r] - p.b) < 4L * p.a * p.c)) {
                    System.out.println("YES");
                    System.out.println(slope[r]);
                    continue;
                }

                System.out.println("NO");
            }
        }
    }

    /*
     * x coored is b/2a if x < 0 towards right else left
     * if the parabola contains (0, 0) then NO
     * find the tangent to the parabola and binary search for any valid idx
     * 
     * tangent from (0, 0) to the parabola
     * 
     * (b-k)^2 < 4ac
     */

}