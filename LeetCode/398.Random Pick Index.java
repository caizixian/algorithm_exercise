import java.util.HashMap;
import java.util.Random;

public class Solution {
    final private Random rand;
    private int[] nums;

    public Solution(int[] nums) {
        rand = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int target_idx = 1;
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (rand.nextInt(target_idx) == 0) {
                    result = i;
                }
                target_idx++;
            }
        }
        return result;
    }
}