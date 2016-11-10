public class Solution {
    public int maxProduct(int[] a) {
        // The subarray and subsequences you consider should have at least one element.
        int max_prod = a[0];
        int min_prod = a[0];
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            int temp1 = max_prod * a[i];
            int temp2 = min_prod * a[i];
            min_prod = Math.min(a[i], Math.min(temp1, temp2));
            max_prod = Math.max(a[i], Math.max(temp1, temp2));
            if (max_prod > max) {
                max = max_prod;
            }
            if (min_prod < min) {
                min = min_prod;
            }
        }
        return max;
    }
}