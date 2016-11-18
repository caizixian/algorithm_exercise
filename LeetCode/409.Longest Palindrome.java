import java.util.HashMap;

public class Solution {

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char ch : s.toCharArray()) {
            count.merge(ch, 1, (c, one) -> c + one);
        }

        int length = 0;
        int odd_count = 0;
        for (int i : count.values()) {
            length += i;
            if (i % 2 != 0) {
                odd_count++;
            }
        }
        if (odd_count != 0) {
            length -= odd_count; // Only use even numbers of characters
            length++; // Except one
        }
        return length;
    }
}