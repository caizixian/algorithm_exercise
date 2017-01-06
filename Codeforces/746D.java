import java.util.*;

public class Solution {
    private static void printRepeat(char ch, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(ch);
        }
    }

    private static void
    optimizeBatch(int more, char a, int less, char b, int consecutive) {
        int batches = (int) Math.ceil(more / (double) consecutive);

        int minNeedLess = batches - 1;
        if (less < minNeedLess) {
            System.out.println("NO");
            return;
        }

        if (less > consecutive * (batches - 1)) {
            for (int i = 1; i <= batches; i++) {
                printRepeat(a, Math.min(more, consecutive));
                more -= consecutive;
                printRepeat(b, Math.min(less, consecutive));
                less -= Math.min(less, consecutive);
            }
        } else {
            for (int i = 1; i <= batches; i++) {
                printRepeat(a, Math.min(more, consecutive));
                more -= consecutive;
                int eachBatch = (int) Math.ceil(less / (double) (batches-i));
                printRepeat(b, Math.min(less, eachBatch));
                less -= Math.min(less, eachBatch);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cups = in.nextInt();
        int consecutive = in.nextInt();
        int green = in.nextInt();
        int black = in.nextInt();

        if (consecutive == 0) {
            System.out.println("NO");
            return;
        }

        if (green >= black) {
            optimizeBatch(green, 'G', black, 'B', consecutive);
        } else {
            optimizeBatch(black, 'B', green, 'G', consecutive);
        }
    }
}