import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.merge(i, 1, (v, one) -> v + one);
        }
        int[] result = new int[2];
        int i = 0;
        for (HashMap.Entry<Integer, Integer> e : count.entrySet()) {
            if (e.getValue() == 1) {
                result[i] = e.getKey();
                i++;
            }
        }
        return result;
    }
}