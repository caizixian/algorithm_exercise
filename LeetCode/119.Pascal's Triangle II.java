import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex);
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            result.add((int) (result.get(i - 1) * (long) (rowIndex - i + 1) / i));
        }
        return result;
    }
}