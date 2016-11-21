import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        int[] sum = new int[digits.length + 1];
        for (int i = 0; i < digits.length; i++) {
            sum[sum.length - i - 1] += digits[digits.length - i - 1];
            if (i == 0) {
                sum[sum.length - i - 1]++;
            }
            if (sum[sum.length - i - 1] > 9) {
                sum[sum.length - i - 2]++;
                sum[sum.length - i - 1] = sum[sum.length - i - 1] % 10;
            }
        }
        if (sum[0] == 0) {
            return Arrays.copyOfRange(sum, 1, sum.length);
        }
        return sum;
    }
}