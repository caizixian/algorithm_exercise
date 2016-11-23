import java.util.LinkedList;
import java.util.List;

public class Solution {
    final private LinkedList<Integer> result = new LinkedList<>();

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        result.add(root.val);
        traverse(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return result;
    }
}