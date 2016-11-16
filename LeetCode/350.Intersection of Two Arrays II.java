import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> count1 = new HashMap<>();
        for (int i : nums1) {
            count1.merge(i, 1, (count, one) -> count + one);
        }
        HashMap<Integer, Integer> count2 = new HashMap<>();
        for (int i : nums2) {
            count2.merge(i, 1, (count, one) -> count + one);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : count1.keySet()) {
            if (count2.containsKey(i)) {
                result.addAll(Collections.nCopies(Math.min(count1.get(i), count2.get(i)), i));
            }
        }
        return result.stream().mapToInt(one -> one).toArray();
    }
}