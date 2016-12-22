import java.util.List;
import java.util.LinkedList;

public class Solution {
    private int[] nums;

    private void mark(int a) {
        if (nums[a - 1] > 0) {
            nums[a - 1] = -nums[a - 1];
        }
    }

    private int actualNum(int i) {
        if (nums[i] < 0) {
            return -nums[i];
        } else {
            return nums[i];
        }
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 1 ≤ a[i] ≤ n
        this.nums = nums;
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            mark(actualNum(i));
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}