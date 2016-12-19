import java.util.Arrays;

public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        // minimum number of intervals to remove
        // -> maximum number of non-conflict intervals we can choose
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a.end - b.end);
        int end = intervals[0].end;
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = intervals[i];
            if (interval.start >= end) {
                end = interval.end;
                count++;
            }
        }
        return intervals.length - count;
    }
}