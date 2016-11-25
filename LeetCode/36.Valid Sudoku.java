import java.util.Arrays;

public class Solution {

    private boolean isValidCell(char[][] board, int x, int y) {
        boolean check[] = new boolean[10];
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                int ch = board[i][j] == '.' ? 0 : board[i][j] - '0';
                if (ch == 0) {
                    continue; // Empty
                }
                if (check[ch]) {
                    return false;
                }
                check[ch] = true;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[] check = new boolean[10];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(check, false);
            // Checking row
            for (int j = 0; j < 9; j++) {
                int ch = board[i][j] == '.' ? 0 : board[i][j] - '0';
                if (ch == 0) {
                    continue; // Empty
                }
                if (check[ch]) {
                    return false;
                }
                check[ch] = true;
            }
        }

        for (int j = 0; j < 9; j++) {
            Arrays.fill(check, false);
            // Checking column
            for (int i = 0; i < 9; i++) {
                int ch = board[i][j] == '.' ? 0 : board[i][j] - '0';
                if (ch == 0) {
                    continue; // Empty
                }
                if (check[ch]) {
                    return false;
                }
                check[ch] = true;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean result = isValidCell(board, i, j);
                if (!result) {
                    return false;
                }
            }
        }
        return true;
    }
}