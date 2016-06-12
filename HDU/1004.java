import java.util.HashMap;
import java.util.Scanner;
import java.util.Collections;
import java.util.Map;

public class Main {
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        while (stdin.hasNextInt()) {
            HashMap<String, Integer> balloonCount = new HashMap<>();
            int caseCount = Integer.parseInt(stdin.nextLine());
            if (caseCount == 0) {
                break;
            }
            for (int i = 1; i <= caseCount; i++) {
                String balloonColor = stdin.nextLine();
                balloonColor = balloonColor.trim();
                if (balloonCount.get(balloonColor) != null) {
                    Integer currentCount = balloonCount.get(balloonColor);
                    balloonCount.put(balloonColor, currentCount + 1);
                } else {
                    balloonCount.put(balloonColor, 1);
                }
            }
            int maxBalloonCount = (Collections.max(balloonCount.values()));
            for (Map.Entry<String, Integer> entry : balloonCount.entrySet()) {
                if (entry.getValue() == maxBalloonCount) {
                    System.out.println(entry.getKey());
                }
            }
        }
    }
}