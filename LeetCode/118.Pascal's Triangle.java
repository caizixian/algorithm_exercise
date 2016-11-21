import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 1; j <= i; j++) {
                if (j != i) {
                    row.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
                } else {
                    row.add(1);
                }
            }
            result.add(row);
        }
        return result;
    }
}