import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lemons = in.nextInt();
        int apples = in.nextInt();
        int pears = in.nextInt();

        double max_group = Math.min(apples / 2.0, Math.min(pears / 4.0, lemons / 1.0));

        System.out.println(7 * (int) Math.floor(max_group));
    }
}