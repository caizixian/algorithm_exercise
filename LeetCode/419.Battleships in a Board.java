public class Solution {
    public int countBattleships(char[][] board) {
        boolean[][] marked = new boolean[board.length][board[0].length];
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' && !marked[i][j]) {
                    count++;
                    marked[i][j] = true;
                    // The ship is horizontal
                    for (int horizontal = j + 1; horizontal < board[0].length; horizontal++) {
                        if (board[i][horizontal] == 'X') {
                            marked[i][horizontal] = true;
                        } else {
                            break;
                        }
                    }
                    // The ship is vertical
                    for (int vertical = i + 1; vertical < board.length; vertical++) {
                        if (board[vertical][j] == 'X') {
                            marked[vertical][j] = true;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        return count;
    }
}