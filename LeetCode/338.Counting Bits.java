public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        // Trivial case
        result[0] = 0;
        result[1] = 1;
        int upper = (int) Math.floor(Math.log(num) / Math.log(2)) + 1;
        for (int pow = 1; pow <= upper; pow++) {
            int start = (int) Math.pow(2, pow);
            int end = (int) (Math.pow(2, pow + 1) - 1);
            for (int i = start; i <= end; i++) {
                if (i > num) {
                    break;
                }
                result[i] = result[i - start] + 1;
            }
        }
        return result;
    }
}