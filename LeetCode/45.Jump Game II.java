public class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length];
        int visited = 0;
        for (int i = 0; i < length; i++) {
            for (int j = visited + 1; j <= i + nums[i] && j < length; j++) {
                dp[j] = dp[i] + 1;
                visited++;
            }
        }
        return dp[length - 1];
    }
}