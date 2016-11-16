public class Solution {
    public int removeDuplicates(int[] nums) {
        int w_ptr = 0;
        int duplicate_counter = 0;
        for (int r_ptr = 1; r_ptr < nums.length; r_ptr++) {
            if (nums[r_ptr] == nums[r_ptr - 1]) {
                //Duplicate
                duplicate_counter++;
            } else {
                duplicate_counter = 0;
            }
            if (duplicate_counter <= 1) {
                nums[w_ptr + 1] = nums[r_ptr];
                w_ptr++;
            }
        }
        return w_ptr + 1;
    }
}