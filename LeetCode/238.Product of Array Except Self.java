public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] result = new int[nums.length];
        if (nums.length == 1) {
            result[0] = 0;
            return result;
        }
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[0] *= nums[i];
        }

        for (int i = 1; i < result.length; i++) {
            if (nums[i] == 0) {
                result[i] = 1;
                for (int j = 0; j < nums.length; j++) {
                    if (j != i) {
                        result[i] *= nums[j];
                    }
                }
            } else {
                result[i] = result[i - 1] / nums[i] * nums[i - 1];
            }
        }
        return result;
    }
}