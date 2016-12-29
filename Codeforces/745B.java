import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int columns = in.nextInt();
        boolean[][] puzzle = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            String row = in.next();
            for (int j = 0; j < columns; j++) {
                puzzle[i][j] = row.charAt(j) != '.';
            }
        }

        // Guess range
        int rectangleStartR = -1;
        int rectangleStartC = -1;

        loop:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (puzzle[i][j]) {
                    rectangleStartR = i;
                    rectangleStartC = j;
                    break loop;
                }
            }
        }
        if (rectangleStartC == -1) {
            System.out.println("NO");
            return;
        }

        int rectangleEndR = -1;
        for (int i = rectangleStartR; i < rows; i++) {
            if (puzzle[i][rectangleStartC]) {
                rectangleEndR = i;
            } else {
                break;
            }
        }


        int rectangleEndC = -1;
        for (int i = rectangleStartC; i < columns; i++) {
            if (puzzle[rectangleStartR][i]) {
                rectangleEndC = i;
            } else {
                break;
            }
        }

        for (int i = rectangleEndR + 1; i < rows; i++) {
            // All rows below expected range
            for (int j = 0; j < columns; j++) {
                if (puzzle[i][j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        for (int i = rectangleStartR + 1; i <= rectangleEndR; i++) {
            // All rows within expected range
            for (int j = 0; j < columns; j++) {
                if (j >= rectangleStartC && j <= rectangleEndC) {
                    // Columns within range
                    if (!puzzle[i][j]) {
                        System.out.println("NO");
                        return;
                    }
                } else {
                    // Columns outside range
                    if (puzzle[i][j]) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }

        System.out.println("YES");
    }
}