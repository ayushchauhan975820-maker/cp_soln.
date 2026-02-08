import java.util.*;

public class A_The_Bento_Box_Adventure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean arr[] = new boolean[6];

        for (int i = 0; i < 4; i++) {
            int id = sc.nextInt();

            arr[id] = true;
        }

        for (int i = 1; i < 6; i++) {
            if (!arr[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}