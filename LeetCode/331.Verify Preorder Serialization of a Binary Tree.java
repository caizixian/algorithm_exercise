import java.util.LinkedList;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        LinkedList<Character> stack = new LinkedList<>();
        String[] tokens = preorder.split(",");
        for (int i = 0; i < tokens.length; i++) {
            char ch = tokens[i].charAt(0);
            if (ch != '#') {
                stack.push(ch);
            } else {
                while (stack.size() >= 2 && stack.peek() == '#') {
                    stack.pop();
                    if (stack.pop() == '#') {
                        return false; // ## then #
                    }
                }
                stack.push('#');
            }
        }
        return stack.size() == 1 && stack.peek() == '#';
    }
}