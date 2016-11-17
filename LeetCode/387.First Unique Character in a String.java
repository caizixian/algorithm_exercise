public class Solution {
    public int firstUniqChar(String s) {
        int[] idx = new int[26]; // the string contain only lowercase letters.
        // idx[] contains 0 for chars not appearing
        // -1 for duplication
        // int for index+1
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (idx[c] == 0) {
                idx[c] = i + 1;
            } else if (idx[c] > 0) {
                idx[c] = -1;
            }
        }
        int min_idx = Integer.MAX_VALUE;
        for (int i : idx) {
            if (i > 0) {
                if (i < min_idx) {
                    min_idx = i;
                }
            }
        }
        if (min_idx == Integer.MAX_VALUE) {
            // If it doesn't exist, return -1.
            return -1;
        }
        return min_idx - 1;
    }
}