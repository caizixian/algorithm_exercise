import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int problems = in.nextInt();
        int minutesHave = 240 - in.nextInt();
        int canSolve = (int) Math.floor((-1.0 + Math.sqrt(1 + 8 * minutesHave / 5)) / 2.0);
        System.out.println(Math.min(canSolve, problems));
    }
}