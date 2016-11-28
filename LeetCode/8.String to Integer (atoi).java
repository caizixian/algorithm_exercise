public class Solution {
    private boolean overflow(long a, boolean sign) {
        if (a > 2147483647 || a < -2147483648) {
            return true;
        } else {
            return false;
        }
    }

    private int truncate(long a, boolean sign) {
        if (sign) {
            return 2147483647;
        } else {
            return -2147483648;
        }
    }

    public int myAtoi(String str) {
        long result;
        String in = str.trim();
        boolean valid_number = false;
        boolean sign = true;//Plus
        if (in.length() == 0) {
            return 0;
        }
        if (in.charAt(0) == '-') {
            result = 0;
            sign = false;
        } else if (in.charAt(0) == '+') {
            result = 0;
            sign = true;
        } else if (Character.isDigit(in.charAt(0))) {
            valid_number = true;
            sign = true;
            result = in.charAt(0) - '0';
        } else {
            return 0; // Not valid
        }
        int i;
        for (i = 1; i < in.length(); i++) {
            if (Character.isDigit(in.charAt(i))) {
                result *= 10;
                result += in.charAt(i) - '0';
                if (overflow(result, sign)) {
                    return truncate(result, sign);
                }
            } else {
                break;
            }
        }
        // i stopping idx (out of bound or invalid or break)
        valid_number = valid_number | i > 1; // Has some digits or has processed some digits
        if (valid_number) {
            if (sign) {
                return Math.toIntExact(result);
            } else {
                return Math.toIntExact(0 - result);
            }
        } else {
            return 0;
        }
    }
}