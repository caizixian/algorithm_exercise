public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] solutions = new int[m][n];
        for (int i = 0; i < m; i++) {
            solutions[i][0] = 1; // Left edge
        }
        for (int i = 0; i < n; i++) {
            solutions[0][i] = 1; // Top edge
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                solutions[i][j] = solutions[i - 1][j] + solutions[i][j - 1];
            }
        }
        return solutions[m - 1][n - 1];
    }
}