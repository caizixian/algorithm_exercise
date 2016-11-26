import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] tokens = str.split(" ");
        HashMap<String, Character> mapping = new HashMap<>();
        HashMap<Character, String> rev_mapping = new HashMap<>();
        if (tokens.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < tokens.length; i++) {
            if (!mapping.containsKey(tokens[i]) && !rev_mapping.containsKey(pattern.charAt(i))) {
                mapping.put(tokens[i], pattern.charAt(i));
                rev_mapping.put(pattern.charAt(i), tokens[i]);
            } else {
                if (mapping.containsKey(tokens[i]) && mapping.get(tokens[i]) != pattern.charAt(i)) {
                    return false;
                }
                if (rev_mapping.containsKey(pattern.charAt(i)) && !rev_mapping.get(pattern.charAt(i)).equals(tokens[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}