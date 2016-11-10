public class Solution {
    public boolean isSubsequence(String s, String t) {
        int sum = 0;
        int i = 0;
        int j = 0;
        while (sum < s.length() && i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                sum++;
                i++;
            }
            j++;
        }
        return sum == s.length();
    }
}