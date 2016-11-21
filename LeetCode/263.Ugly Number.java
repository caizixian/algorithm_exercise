public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false; // Ugly numbers are positive numbers whose prime factors only include 2, 3, 5
        }
        if (num == 1) {
            return true; // 1 is typically treated as an ugly number.
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}