public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        if (str.length() <= 1) {
            return false;
        }
        for (int i = 0; i < Math.ceil(str.length() / 2.0); i++) {
            // 0~i as substring
            if (str.length() % (1 + i) != 0) {
                continue;
            }
            String subpattern = str.substring(0, i + 1);
            boolean repeated = true;
            for (int j = i + 1; j < str.length(); j += (i + 1)) {
                if (!str.substring(j, j + i + 1).equals(subpattern)) {
                    repeated = false;
                    break;
                }
            }
            if (repeated) {
                return true;
            }
        }
        return false;
    }
}