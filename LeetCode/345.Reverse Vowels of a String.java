import java.util.LinkedList;

public class Solution {
    public String reverseVowels(String s) {
        LinkedList<Integer> vowels = new LinkedList<>();
        char[] str = s.toCharArray();
        String vowel = "AaEeIiOoUu";
        for (int i = 0; i < str.length; i++) {
            if (vowel.indexOf(str[i]) >= 0) {
                vowels.add(i);
            }
        }
        while (vowels.size() > 1) {
            int first = vowels.removeFirst();
            int second = vowels.removeLast();
            char temp = str[first];
            str[first] = str[second];
            str[second] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : str) {
            sb.append(c);
        }
        return sb.toString();
    }
}