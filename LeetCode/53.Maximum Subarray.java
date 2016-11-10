public class Solution {
    public int maxSubArray(int[] a) {
        int max_sum = a[0]; // The subarray and subsequences you consider should have at least one element.
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max_sum + a[i] > a[i]) {
                max_sum += a[i];
            } else {
                max_sum = a[i];
            }

            if (max_sum > max) {
                max = max_sum;
            }
        }
        return max;
    }
}