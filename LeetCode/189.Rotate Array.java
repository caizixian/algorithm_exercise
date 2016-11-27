public class Solution {
    public void rotate(int[] nums, int k) {
        int[] original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = original[((i - k) % nums.length + nums.length) % nums.length];
        }
    }
}