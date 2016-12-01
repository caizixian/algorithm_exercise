public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        long sum = n * (n + 1) / 2;
        for (int i : nums) {
            sum -= i;
        }
        return Math.toIntExact(sum);
    }
}