public class Solution {

    private String hexToString(int[] hex) {
        StringBuilder result = new StringBuilder();
        boolean print_zero = false;
        for (int i = 0; i < hex.length; i++) {
            print_zero = print_zero || hex[i] != 0;
            if (hex[i] == 0) {
                if (print_zero) {
                    result.append(0);
                }
            } else if (hex[i] > 9) {
                result.append((char) ('a' + hex[i] - 10));
            } else {
                result.append(hex[i]);
            }
        }
        if (!print_zero) {
            return "0";
        }
        return result.toString();
    }

    public String toHex(int num) {
        int[] hex = new int[8];
        long abs_num = Math.abs(num);
        for (int i = 7; i >= 0; i--) {
            hex[i] = (int) abs_num % 16;
            abs_num /= 16;
        }
        if (num < 0) {
            for (int i = 7; i >= 0; i--) {
                hex[i] = 15 - hex[i];
            }
            int carry = 0;
            hex[7]++;
            for (int i = 7; i >= 0; i--) {
                if (hex[i] > 15) {
                    hex[i] = hex[i] % 16;
                    if (i != 0) {
                        hex[i - 1]++;
                    }
                }
            }
        }
        return hexToString(hex);
    }
}