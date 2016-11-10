public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] solutions = new int[m + 1][n + 1];
        solutions[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    solutions[i][j] = 0; // Is obstacle
                    continue;
                }
                if (i == j && j == 1) {
                    continue; // Skip updating top-left corner
                }
                solutions[i][j] = solutions[i - 1][j] + solutions[i][j - 1];
            }
        }
        return solutions[m][n];
    }
}