import java.util.Arrays;

public class Solution {
    private boolean covered(int[] houses, int heaters[], int radius) {
        int heaterPtr = 0;
        int housePtr = 0;
        while (heaterPtr < heaters.length && housePtr < houses.length) {
            int rangeLo = heaters[heaterPtr] - radius;
            int rangeHi = heaters[heaterPtr] + radius;
            int houseCoordinate = houses[housePtr];
            if (houseCoordinate >= rangeLo && houseCoordinate <= rangeHi) {
                housePtr++;
            } else {
                heaterPtr++;
            }
        }
        return housePtr == houses.length;
    }

    public int findRadius(int[] houses, int[] heaters) {
        if (houses.length == 0) {
            return 0;
        }
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int lo = 0;
        int hi = Math.max(Math.abs(heaters[0] - houses[0]), Math.abs(heaters[0] - houses[houses.length - 1]));
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (covered(houses, heaters, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}