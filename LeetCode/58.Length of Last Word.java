public class Solution {
    public int lengthOfLastWord(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(Math.max(i - 1, 0)) == ' ' && s.charAt(i) != ' ') {
                // Encounter another word, reset counter
                counter = 0;
            }
            if (s.charAt(i) != ' ') {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("  123"));
    }
}