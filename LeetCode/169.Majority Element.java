import java.util.HashMap;

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.merge(i, 1, (c, one) -> c + one);
            if (count.get(i) > nums.length / 2) {
                return i;
            }
        }
        return -1;
    }
}