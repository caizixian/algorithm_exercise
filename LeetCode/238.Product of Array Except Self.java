public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] result = new int[nums.length];
        // i 0~len exclusive
        // result[i] = pi(0~i)*pi(i+1~len) (exclusive)
        // compute pi(0~i) (exclusive first)
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int accumulator = nums[nums.length - 1]; // Store pi(i+1~len)
        for (int i = nums.length - 2; i >= 0; i--) {
            // result[i] = pi (0~i)
            result[i] *= accumulator;
            accumulator *= nums[i];
        }
        return result;
    }
}