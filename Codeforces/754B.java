import java.util.*;

public class Solution {
    private static boolean
    up(char[][] board, int count, int i, int j) {
        int I = i;
        int J = j - count;
        if (J < 0 || J > 3) {
            return false;
        }
        return board[I][J] == 'x';
    }

    private static boolean
    left(char[][] board, int count, int i, int j) {
        int I = i - count;
        int J = j;
        if (I < 0 || I > 3) {
            return false;
        }
        return board[I][J] == 'x';
    }

    private static boolean
    diagonal(char[][] board, int rotation, int count, int i, int j) {
        int incrementI = -10000;
        int incrementJ = -10000;
        switch (rotation) {
            case 1:
                incrementI = 1;
                incrementJ = 1;
                break;
            case 2:
                incrementI = 1;
                incrementJ = -1;
                break;
        }
        int I;
        int J;
        I = i + incrementI * count;
        J = j + incrementJ * count;
        if (I < 0 || I > 3 || J < 0 || J > 3) {
            return false;
        }
        return board[I][J] == 'x';
    }

    private static boolean checkHorizontal(char[][] board, int i, int j) {
        boolean case1, case2, case3;
        case1 = up(board, 2, i, j) &&
                up(board, 1, i, j);
        case2 = up(board, 1, i, j) &&
                up(board, -1, i, j);
        case3 = up(board, -1, i, j) &&
                up(board, -2, i, j);
        return case1 || case2 || case3;
    }

    private static boolean checkVertical(char[][] board, int i, int j) {
        boolean case1, case2, case3;
        case1 = left(board, 2, i, j) &&
                left(board, 1, i, j);
        case2 = left(board, 1, i, j) &&
                left(board, -1, i, j);
        case3 = left(board, -1, i, j) &&
                left(board, -2, i, j);
        return case1 || case2 || case3;
    }

    private static boolean checkDiagonal(char[][] board, int i, int j) {
        for (int rotation = 1; rotation <= 2; rotation++) {
            boolean case1, case2, case3;
            case1 = diagonal(board, rotation, 2, i, j) &&
                    diagonal(board, rotation, 1, i, j);
            case2 = diagonal(board, rotation, 1, i, j) &&
                    diagonal(board, rotation, -1, i, j);
            case3 = diagonal(board, rotation, -1, i, j) &&
                    diagonal(board, rotation, -2, i, j);
            if (case1 || case2 || case3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] board = new char[4][4];

        for (int i = 0; i < 4; i++) {
            String input = in.nextLine().trim();
            for (int j = 0; j < 4; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != '.') {
                    // Already placed crosses or noughts
                    continue;
                }
                if (checkDiagonal(board, i, j) ||
                        checkHorizontal(board, i, j) ||
                        checkVertical(board, i, j)) {
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");
    }
}