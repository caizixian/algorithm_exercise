import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Solution {
    private LinkedList<Integer> result = new LinkedList<>();
    private ArrayList<Character> operators = new ArrayList<>();
    private ArrayList<Integer> numbers = new ArrayList<>();
    private LinkedList<Integer>[][] cache;

    private LinkedList<Integer> search(int i, int j) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }
        LinkedList<Integer> result = new LinkedList<>();
        if (i == j) {
            result.add(numbers.get(i));
        } else if (i + 1 == j) {
            result.add(combine(numbers.get(i), numbers.get(j), i));
        } else {
            for (int k = i; k < j; k++) {
                LinkedList<Integer> left = search(i, k);
                LinkedList<Integer> right = search(k + 1, j);
                for (Integer l : left) {
                    for (Integer r : right) {
                        result.add(combine(l, r, k));
                    }
                }
            }
        }
        cache[i][j] = result;
        return result;
    }

    public int combine(int i, int j, int operatorIdx) {
        switch (operators.get(operatorIdx)) {
            case '+':
                return i + j;
            case '-':
                return i - j;
            case '*':
                return i * j;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public List<Integer> diffWaysToCompute(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                operators.add(c);
                numbers.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        numbers.add(Integer.parseInt(sb.toString()));
        cache = new LinkedList[numbers.size()][numbers.size()];
        search(0, numbers.size() - 1);
        return cache[0][numbers.size() - 1];
    }
}