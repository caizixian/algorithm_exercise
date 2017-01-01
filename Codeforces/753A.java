import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int candies = in.nextInt();
        int count = (int) Math.floor((-1.0 + Math.sqrt(1 + 8 * candies)) / 2.0);
        System.out.println(count);
        for (int i = 1; i < count; i++) {
            System.out.print(i + " ");
            candies -= i;
        }
        System.out.print(candies);
    }
}