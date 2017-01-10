import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int exponent = in.nextInt();
        int[] ending = new int[]{6, 8, 4, 2};
        if (exponent == 0) {
            System.out.println(1);
        } else {
            System.out.println(ending[exponent % 4]);
        }
    }
}