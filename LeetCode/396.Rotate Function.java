public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int arr_sum = 0;
        for (int i = 0; i < A.length; i++) {
            arr_sum += A[i];
        }

        int rotation_sum = 0;
        // Rotation 0
        for (int i = 0; i < A.length; i++) {
            rotation_sum += i * A[i];
        }

        int max = rotation_sum;

        for (int k = 1; k < A.length; k++) {
            // Rotation 1~k
            rotation_sum = rotation_sum + arr_sum - A.length * A[A.length - k];
            if (rotation_sum > max) {
                max = rotation_sum;
            }
        }

        return max;
    }
}