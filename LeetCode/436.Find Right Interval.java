import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> minStartIdx = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            // You may assume none of these intervals have the same start point.
            minStartIdx.put(intervals[i].start, i);
        }
        int[] result = new int[intervals.length];
        for (int i = 0; i < result.length; i++) {
            int end = intervals[i].end;
            Map.Entry<Integer, Integer> right_interval = minStartIdx.ceilingEntry(end);
            if (right_interval != null) {
                result[i] = right_interval.getValue();
            } else {
                result[i] = -1;
            }
        }
        return result;
    }
}