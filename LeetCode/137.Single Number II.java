public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            // Use bits of ones and twos as a 3 counter
            // (twos, ones)
            // Statuses: (0 0) (0 1) (1 0) (1 1)
            twos |= (ones & nums[i]); // need to carry
            ones = ones ^ nums[i]; // incr

            // Reset if necessary
            int reset = twos & ones; // if reset = 1 then 1 1
            twos = twos ^ reset;// 1^1==0
            ones = ones ^ reset;// 1^1==0
        }
        return ones;
    }
}