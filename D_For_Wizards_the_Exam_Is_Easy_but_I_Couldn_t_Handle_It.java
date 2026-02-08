import java.util.*;
import java.io.*;

public class D_For_Wizards_the_Exam_Is_Easy_but_I_Couldn_t_Handle_It {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int a[] = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int l = 0;
            int r = 0;
            int max = -1;
            for (int i = 0; i < n; i++) {
                int lm = -1;
                int inv = 0;
                int e = i;
                for (int j = i; j < n; j++) {
                    if (a[j] > a[i]) {
                        inv--;
                    }
                    if (a[j] < a[i]) {
                        inv++;
                    }

                    if (inv > lm) {
                        lm = inv;
                        e = j;
                    }
                }

                if (lm > max) {
                    max = lm;
                    l = i;
                    r = e;
                }
            }

            out.println((l + 1) + " " + (r + 1));
        }

        out.close();
    }
}