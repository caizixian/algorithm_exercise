public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        int visited = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = visited + 1; j <= i + nums[i] && j < nums.length; j++) {
                dp[j] = dp[i];
                visited++;
            }
        }
        return dp[nums.length - 1];
    }
}