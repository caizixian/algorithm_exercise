import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        boolean allZero = true;
        int sum = 0;
        int[] num = new int[size];
        for (int i = 0; i < size; i++) {
            num[i] = in.nextInt();
            sum += num[i];
            if (num[i] != 0) {
                allZero = false;
            }
        }

        if (sum == 0 && allZero) {
            // trivial
            System.out.println("NO");
            return;
        }

        if (sum == 0) {
            int temp = 0;
            int i;
            for (i = 0; i < size; i++) {
                temp += num[i];
                if (temp != 0) {
                    break;
                }
            }
            System.out.println("YES");
            System.out.println(2);
            System.out.println(1 + " " + (i + 1));
            System.out.println((i + 2) + " " + size);
        } else {
            // trivial
            System.out.println("YES");
            System.out.println(1);
            System.out.println(1 + " " + size);
        }
    }
}