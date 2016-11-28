public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int group_length = (numRows - 1) * 2;

        for (int i = 0; i < numRows; i++) {
            // ith row
            for (int j = 0; j < Math.ceil(length / (double) numRows); j++) {
                int left = group_length * j + i;
                int right = group_length * (j + 1) - i;
                // Prevent double insertion for 0 and numRows-1
                if (left < length) {
                    sb.append(s.charAt(left));
                }
                if (i != 0 && i != numRows - 1) {
                    if (right < length) {
                        sb.append(s.charAt(right));
                    }
                }
            }
        }
        return sb.toString();
    }
}