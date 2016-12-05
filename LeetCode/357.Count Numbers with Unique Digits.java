public class Solution {
    private int numberWithUniqueDigitsPow(int pow) {
        // Range min(0,10^(pow-1))~10^(pow) (inclusive, exclusive)
        if (pow == 0) {
            return 1;
        } else if (pow == 1) {
            return 9;
        }
        int result = 9; // Choose first digit (1~9)
        for (int i = 9; i > 9 - pow + 1; i--) {
            // Choose other digits
            result *= i;
        }
        return result;
    }

    public int countNumbersWithUniqueDigits(int n) {
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result += numberWithUniqueDigitsPow(i);
        }
        return result;
    }
}
