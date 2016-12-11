import java.util.List;
import java.util.LinkedList;

public class Solution {
    private final List<List<Integer>> result = new LinkedList<>();
    private final LinkedList<Integer> combination = new LinkedList<>();

    private void search(int start, int sum, int count) {
        if (sum == 0) {
            if (count == 0) {
                result.add((LinkedList) combination.clone());
            } else {
                return;
            }
        }
        if (start > sum) {
            return;
        }
        for (int i = start; i <= Math.min(sum, 9); i++) {
            combination.add(i);
            search(i + 1, sum - i, count - 1);
            combination.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        search(1, n, k);
        return result;
    }
}