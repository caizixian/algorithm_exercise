public class Solution {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum = sum ^ i;
        }
        // sum=b^c
        int diff_bit;
        for (diff_bit = 0; diff_bit <= 32; diff_bit++) {
            if ((sum & 1) == 1) {
                break;
            } else {
                sum = sum >> 1;
            }
        }
        // diff_bit th bits of b and c are different
        int comp = 1 << diff_bit;
        int[] result = new int[2];
        for (int i : nums) {
            if ((i & comp) > 0) {
                result[0] = result[0] ^ i;
            } else {
                result[1] = result[1] ^ i;
            }
        }
        return result;
    }
}