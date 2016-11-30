import java.util.Arrays;

public class Solution {
    public int minMoves2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);

        int median;
        if (nums.length % 2 == 0) {
            median = Math.toIntExact(((long) nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2);
        } else {
            median = nums[nums.length / 2];
        }
        // moves = nums_smaller*target - range_sum(0,i)
        //         +range_sum(i+1, len-1)-nums_bigger*target
        // Choose median to minimize moves
        int min_moves = 0;
        for (int i = 0; i < nums.length; i++) {
            min_moves += Math.abs(nums[i] - median);
        }
        return min_moves;
    }
}