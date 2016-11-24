public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int current = low + (high - low) / 2;
            if (isBadVersion(current)) {
                high = current;
            } else {
                low = current + 1;
            }
        }
        return low;
    }
}