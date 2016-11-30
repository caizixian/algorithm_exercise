public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        for (int i = 0; i <= A.length-3; i++) {
            int difference = A[i + 1] - A[i];
            for (int j = i + 2; j < A.length; j++) {
                if (A[j] - A[j - 1] == difference) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}