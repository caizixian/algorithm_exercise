public class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - i - 1);
        }
        return sum;
    }
}