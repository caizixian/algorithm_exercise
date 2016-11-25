public class Solution {
    public int trailingZeroes(int n) {
        int sum = 0;
        long divisor = 5;
        while (n >= divisor) {
            sum += n / divisor;
            divisor *= 5;
        }
        return sum;
    }
}