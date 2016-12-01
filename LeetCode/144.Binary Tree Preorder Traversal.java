import java.util.List;
import java.util.LinkedList;

public class Solution {
    final LinkedList<Integer> result = new LinkedList<>();

    public void traverse(TreeNode root) {
        if (root != null) {
            result.add(root.val);
            traverse(root.left);
            traverse(root.right);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return result;
    }
}