import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.next();
        String movements = in.next();
        int LR = 0; // Null 0 L 1 R 2
        int UD = 0; // Null 0 U 1 R 2
        int count = 1;
        for (char movement : movements.toCharArray()) {
            if (movement == 'L' || movement == 'R') {
                int lr = (movement == 'L') ? 1 : 2;
                if (LR != lr) {
                    if (LR != 0) {
                        count++;
                        UD = 0;
                    }
                    LR = lr;
                }
            } else {
                int ud = (movement == 'U') ? 1 : 2;
                if (UD != ud) {
                    if (UD != 0) {
                        count++;
                        LR = 0;
                    }
                    UD = ud;
                }
            }
        }
        System.out.println(count);
    }
}