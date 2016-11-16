public class Solution {
    public int moveZeroes(int[] nums) {
        int w_ptr = -1;
        for (int r_ptr = 0; r_ptr < nums.length; r_ptr++) {
            if (nums[r_ptr] != 0) {
                nums[w_ptr + 1] = nums[r_ptr];
                w_ptr++;
            }
        }
        for (int i = w_ptr + 1; i < nums.length; i++) {
            nums[i] = 0; // Repopulate zeros at the end
        }
        return w_ptr + 1;
    }
}