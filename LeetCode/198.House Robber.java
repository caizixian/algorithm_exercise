public class Solution {

    int[][] m;

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        this.m = new int[size][2];
        m[0][1] = nums[0];
        for (int i = 1; i < size; i++) {
            m[i][0] = Math.max(m[i-1][0], m[i-1][1]);
            m[i][1] = nums[i]+ m[i-1][0];
        }
        return Math.max(m[size - 1][0], m[size - 1][1]);
    }
}