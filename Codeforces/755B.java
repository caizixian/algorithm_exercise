import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        if (a > b) {
            System.out.println("YES");
        } else if (a < b) {
            System.out.println("NO");
        } else {

            int shared = 0;
            HashSet<String> aKnow = new HashSet<>();
            for (int i = 0; i < a; i++) {
                aKnow.add(in.next());
            }

            for (int i = 0; i < b; i++) {
                String s = in.next();
                if (aKnow.contains(s)) {
                    shared++;
                }
            }

            if (shared % 2 == 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}