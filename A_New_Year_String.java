import java.util.*;

public class A_New_Year_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            boolean has2025 = s.contains("2025");
            boolean has2026 = s.contains("2026");

            if (s.contains("2026") || !s.contains("2025")) {
                System.out.println(0);
                continue;
            }

            System.out.println(1);

        }
    }

    /*
    
    */
}