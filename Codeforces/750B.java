import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int actions = Integer.parseInt(in.nextLine().trim());
        int distanceFromNorth = 0;
        int NORTH_POLE = 0;
        int SOUTH_POLE = 20000;
        for (int i = 0; i < actions; i++) {
            String action = in.nextLine();
            int distance = Integer.parseInt(action.split(" ")[0]);
            String direction = action.split(" ")[1];

            if (direction.equals("North")) {
                distanceFromNorth -= distance;
            }
            if (direction.equals("South")) {
                distanceFromNorth += distance;
            }

            if (direction.equals("East") || direction.equals("West")) {
                if (distanceFromNorth == NORTH_POLE || distanceFromNorth == SOUTH_POLE) {
                    System.out.println("NO");
                    return;
                }
            }

            if (distanceFromNorth > SOUTH_POLE || distanceFromNorth < NORTH_POLE) {
                System.out.println("NO");
                return;
            }
        }
        if (distanceFromNorth == NORTH_POLE) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}