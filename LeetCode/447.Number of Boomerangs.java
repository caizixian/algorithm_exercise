import java.util.HashMap;

public class Solution {

    private int distance(int[] pt1, int[] pt2) {
        return (int) (Math.pow(pt1[0] - pt2[0], 2) + Math.pow(pt1[1] - pt2[1], 2));
    }

    public int numberOfBoomerangs(int[][] points) {
        if (points.length < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> distance_cnt = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                distance_cnt.merge(distance(points[i], points[j]), 1, (c, one) -> c + one);
            }
            for (int cnt : distance_cnt.values()) {
                if (cnt >= 2) {
                    count += cnt * (cnt - 1);
                }
            }
        }
        return count;
    }
}