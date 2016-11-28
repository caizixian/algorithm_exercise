public class Solution {
    private int extract_digit(Integer a, int n) {
        return a.toString().charAt(n) - '0';
    }

    public int findNthDigit(int n) {
        long total_digits = 0;
        int pow;
        for (pow = 0; pow <= 9; pow++) {
            total_digits += 9 * Math.pow(10, pow) * (pow + 1);
            if (total_digits >= n) {
                break;
            }
        }
        total_digits -= 9 * Math.pow(10, pow) * (pow + 1);
        int digits_in_range = n - Math.toIntExact(total_digits);
        // Range (10^pow ~ 10^(pow+1)-1) Each has (pow+1) digits
        int start = (int) Math.pow(10, pow);
        start += (digits_in_range - 1) / (pow + 1); // Start from 100, 3 digits, still 100
        digits_in_range = (digits_in_range - 1) % (pow + 1);
        return extract_digit(start, digits_in_range);
    }
}