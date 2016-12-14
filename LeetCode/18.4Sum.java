import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue; // Skip duplicate
                }
                // Sorted 2 sum
                int lo = j + 1;
                int hi = nums.length - 1;
                int diff = target - nums[i] - nums[j];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] > diff) {
                        hi--;
                    } else if (nums[lo] + nums[hi] < diff) {
                        lo++;
                    } else {
                        LinkedList<Integer> combination = new LinkedList<>();
                        combination.add(nums[i]);
                        combination.add(nums[j]);
                        combination.add(nums[lo]);
                        combination.add(nums[hi]);
                        result.add(combination);
                        // Skip duplicate
                        lo++;
                        hi--;
                        while (lo < hi && nums[lo - 1] == nums[lo]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi + 1] == nums[hi]) {
                            hi--;
                        }
                    }
                }
            }
        }
        return result;
    }
}