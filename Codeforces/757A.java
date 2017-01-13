import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String target = "Bulbasaur";
        Map<Character, Integer> targetCount = new HashMap<>();

        for (char ch : target.toCharArray()) {
            targetCount.merge(ch, 1, (_a, _b) -> _a + _b);
        }

        String input = in.next();

        Map<Character, Integer> inputCount = new HashMap<>();

        for (char ch : input.toCharArray()) {
            inputCount.merge(ch, 1, (_a, _b) -> _a + _b);
        }

        double canForm = 1e7;

        for (Map.Entry<Character, Integer> e : targetCount.entrySet()) {
            int expect = e.getValue();
            int inFact = inputCount.getOrDefault(e.getKey(), 0);

            canForm = Math.min(canForm, (double) inFact / expect);
        }

        System.out.println((int) Math.floor(canForm));
    }
}