import java.util.List;
import java.util.LinkedList;

public class Solution {
    private List<Integer> result;

    private void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level == result.size()) {
            result.add(root.val);
        }

        traverse(root.right, level + 1);
        traverse(root.left, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        traverse(root, 0);
        return result;
    }
}