public class Solution {

    private int sum_digit_square(int n) {
        int sum = 0;
        while (n != 0) {
            int last_digit = n % 10;
            n /= 10;
            sum += last_digit * last_digit;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        Integer[] happy_under_99 = new Integer[]{1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97};
        while (n > 99) {
            n = sum_digit_square(n);
        }
        return Arrays.asList(happy_under_99).contains(n);
    }
}