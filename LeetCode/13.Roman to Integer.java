import java.util.HashMap;

public class Solution {

    public int romanToInt(String s) {
        HashMap<Character, Integer> romamLiteral = new HashMap<>();
        romamLiteral.put('I', 1);
        romamLiteral.put('V', 5);
        romamLiteral.put('X', 10);
        romamLiteral.put('L', 50);
        romamLiteral.put('C', 100);
        romamLiteral.put('D', 500);
        romamLiteral.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = romamLiteral.get(s.charAt(i));
            if (i == s.length() - 1) {
                // Tail
                sum += current;
            } else {
                // Not tail
                int next = romamLiteral.get(s.charAt(i + 1));
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