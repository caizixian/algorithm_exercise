public class Solution {
    private int bisect_right(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] <= key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[len - 1][len - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // Calculate the rank of mid
            int rank = 0;
            for (int[] row : matrix) {
                rank += bisect_right(row, mid);
            }
            if (rank >= k) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}