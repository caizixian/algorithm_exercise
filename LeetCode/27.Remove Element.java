public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
}