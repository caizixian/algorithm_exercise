public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos; // XOR of numbers appear once
            twos = (twos ^ nums[i]) & ~ones; // XOR of numbers appear twice
            // Third time a number appears, it will be removed from ones and twos
        }
        return ones;
    }
}