import java.util.Arrays;

public class Solution {
    public String addStrings(String num1, String num2) {
        int max_length = Math.max(num1.length(), num2.length());
        int[][] sum = new int[3][max_length + 1];
        for (int i = 0; i < max_length; i++) {
            if (i < num1.length()) {
                sum[0][max_length - i] = num1.charAt(num1.length() - i - 1) - '0';
            } else {
                sum[0][max_length - i] = 0;
            }
            if (i < num2.length()) {
                sum[1][max_length - i] = num2.charAt(num2.length() - i - 1) - '0';
            } else {
                sum[1][max_length - i] = 0;
            }
            int total = sum[0][max_length - i] + sum[1][max_length - i] + sum[2][max_length - i];
            if (total > 9) {
                sum[2][max_length - i] = total % 10;
                sum[2][max_length - i - 1] = 1; // Carry
            } else {
                sum[2][max_length - i] = total;
            }
        }
        StringBuilder result = new StringBuilder();
        if (sum[2][0] != 0) {
            result.append(sum[2][0]);
        }
        for (int i = 1; i < max_length + 1; i++) {
            result.append(sum[2][i]);
        }
        return result.toString();
    }
}