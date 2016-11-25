public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        // Construct from end to begin
        int original = x;
        int sum = 0;
        while (x > 0) {
            sum = sum * 10 + x % 10;
            x /= 10;
        }

        if (sum == original) {
            return true;
        }
        return false;
    }
}