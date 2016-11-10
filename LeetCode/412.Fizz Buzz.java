import java.util.List;
import java.util.LinkedList;

public class Solution {
    public List<String> fizzBuzz(int n) {
        LinkedList<String> result = new LinkedList<>();
        for (Integer i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(i.toString());
            }
        }
        return result;
    }
}