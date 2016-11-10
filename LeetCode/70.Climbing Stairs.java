public class Solution {
    public int climbStairs(int n) {
        int[] solutions;
        if (n < 2) {
            solutions = new int[3];
        } else {
            solutions = new int[n + 1];
        }
        solutions[1] = 1;
        solutions[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            solutions[i] = solutions[i - 1] + solutions[i - 2];
        }
        return solutions[n];
    }
}