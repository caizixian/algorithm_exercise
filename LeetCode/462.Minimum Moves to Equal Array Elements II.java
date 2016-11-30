import java.util.Arrays;

public class Solution {
    private long range_sum(long[] sum, int i, int j) {
        // inclusive
        if (i == 0) {
            return sum[j];
        } else {
            return sum[j] - sum[i - 1];
        }
    }

    public int minMoves2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        long min_moves = Long.MAX_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {
            // Use targets between nums[i]~nums[i+1] inclusive
            long target_upper = nums[i + 1];
            long target_lower = nums[i];
            // the number of nums greater than or equal to target
            int nums_bigger = nums.length - i - 1;
            // the number of nums less than or equal to target
            int nums_smaller = i + 1;
            // moves = nums_smaller*target - range_sum(0,i)
            //         +range_sum(i+1, len-1)-nums_bigger*target
            // To minimize moves, we need to minimize (nums_smaller-nums_bigger)*target
            long target;
            if (nums_smaller - nums_bigger >= 0) {
                target = target_lower;
            } else {
                target = target_upper;
            }
            long moves = (nums_smaller - nums_bigger) * target
                    - range_sum(sum, 0, i)
                    + range_sum(sum, i + 1, nums.length - 1);
            if (moves < min_moves) {
                min_moves = moves;
            }
        }
        return Math.toIntExact(min_moves);
    }
}