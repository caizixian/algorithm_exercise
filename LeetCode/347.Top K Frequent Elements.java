import java.util.HashMap;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.merge(i, 1, (v, one) -> v + one);
        }
        HashMap.Entry<Integer, Integer>[] counts = count.entrySet().toArray(new HashMap.Entry[count.size()]);
        Arrays.sort(counts, (a1, a2) -> a2.getValue().compareTo(a1.getValue()));
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            result.add(counts[i].getKey());
        }
        return result;
    }
}