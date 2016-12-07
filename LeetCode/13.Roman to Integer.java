import java.util.HashMap;

public class Solution {

    public int romanToInt(String s) {
        HashMap<Character, Integer> romanLiteral = new HashMap<>();
        romanLiteral.put('I', 1);
        romanLiteral.put('V', 5);
        romanLiteral.put('X', 10);
        romanLiteral.put('L', 50);
        romanLiteral.put('C', 100);
        romanLiteral.put('D', 500);
        romanLiteral.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = romanLiteral.get(s.charAt(i));
            if (i == s.length() - 1) {
                // Tail
                sum += current;
            } else {
                // Not tail
                int next = romanLiteral.get(s.charAt(i + 1));
                if (current < next) {
                    sum -= current;
                } else {
                    sum += current;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("CXCIX"));
    }
}