import java.util.Arrays;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length < 1) {
            return 0;
        }
        Arrays.sort(points,
                (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int result = 1;
        int launch_pt = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] balloon = points[i];
            if (balloon[0] > launch_pt) {
                // Launch an arrow
                result++;
                launch_pt = balloon[1];
            }
        }
        return result;
    }
}