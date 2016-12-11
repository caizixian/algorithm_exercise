import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class Solution {
    final private List<String> result = new LinkedList<>();
    private int end;
    private boolean[] leftParentheses;

    private boolean isValid() {
        int count = 0;
        for (boolean i : leftParentheses) {
            if (i) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        if (count != 0) {
            return false;
        }
        return true;
    }

    private String render() {
        StringBuilder sb = new StringBuilder();
        for (boolean i : leftParentheses) {
            if (i) {
                sb.append('(');
            } else {
                sb.append(')');
            }
        }
        return sb.toString();
    }

    private void search(int start, int parenthesisLeft) {
        if (start > end) {
            return;
        }
        leftParentheses[start] = true;
        if (parenthesisLeft == 1) {
            if (isValid()) {
                result.add(render());
            }
        } else {
            for (int i = start + 1; i <= end; i++) {
                search(i, parenthesisLeft - 1);
            }
        }
        leftParentheses[start] = false;
    }

    public List<String> generateParenthesis(int n) {
        leftParentheses = new boolean[n * 2];
        end = n * 2 - 1;
        search(0, n);
        return result;
    }
}