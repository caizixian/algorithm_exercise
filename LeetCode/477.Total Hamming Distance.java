public class Solution {
    public int totalHammingDistance(int[] nums) {
        // Elements of the given array are in the range of 0 to 10^9
        int result = 0;
        for (int i = 30; i >= 0; i--) {
            int extract = 1 << i;
            int ones = 0;
            int zeros = 0;
            for (int n : nums) {
                if ((n & extract) > 0) {
                    ones++;
                } else {
                    zeros++;
                }
            }
            result += ones * zeros;
        }
        return result;
    }
}