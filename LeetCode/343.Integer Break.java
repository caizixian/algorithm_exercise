public class Solution {
    public int integerBreak(int n) {
        if (n < 2) return 0;
        if (n == 2 || n == 3) return n - 1;
        if (n == 4) return 4;
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        return result * n;
    }
}