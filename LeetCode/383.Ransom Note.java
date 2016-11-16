import java.util.HashMap;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> chars_in_mag = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            chars_in_mag.merge(c, 1, (count, one) -> count + one);
        }
        for (char c : ransomNote.toCharArray()) {
            if (!chars_in_mag.containsKey(c)) {
                return false;
            } else {
                chars_in_mag.compute(c, (k, v) -> (v == 1) ? null : v - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canConstruct("aa", "ab"));
    }
}