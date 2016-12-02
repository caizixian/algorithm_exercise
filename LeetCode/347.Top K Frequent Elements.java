import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.merge(i, 1, (v, one) -> v + one);
        }
        int max_count = 0;
        for (int i : count.keySet()) {
            int v = count.get(i);
            if (v > max_count) {
                max_count = v;
            }
        }
        LinkedList<Integer>[] num_same_count = new LinkedList[max_count + 1];
        for (int i = 1; i <= max_count; i++) {
            num_same_count[i] = new LinkedList<>();
        }
        for (HashMap.Entry<Integer, Integer> e : count.entrySet()) {
            num_same_count[e.getValue()].add(e.getKey());
        }
        LinkedList<Integer> result = new LinkedList<>();
        int c = 0;
        for (int i = max_count; i > 0; i--) {
            if (num_same_count[i].size() > 0) {
                result.addAll(num_same_count[i]);
                c += num_same_count[i].size();
                if (c == k) {
                    break;
                }
            }
        }
        return result;
    }
}