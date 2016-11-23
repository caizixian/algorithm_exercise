import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        String left = "({[";
        HashMap<Character, Character> matching = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        for (char c : s.toCharArray()) {
            if (left.indexOf(c) >= 0) {
                stack.push(c);
            } else {
                if (matching.get(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}