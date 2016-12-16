public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[((i - 1) + len) % len]) {
                return nums[i];
            }
        }
        return -1;
    }
}