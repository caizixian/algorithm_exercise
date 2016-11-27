import java.util.ArrayList;

public class Solution {
    public boolean isPalindrome(String s) {
        ArrayList<Character> chars = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                chars.add(Character.toLowerCase(c));
            }
            if (Character.isDigit(c)) {
                chars.add(c);
            }
        }
        int length = chars.size();
        if (length == 0) {
            return true;
        } else {
            for (int i = 0; i < length / 2; i++) {
                if (!chars.get(i).equals(chars.get(length - 1 - i))) {
                    return false;
                }
            }
        }
        return true;
    }
}