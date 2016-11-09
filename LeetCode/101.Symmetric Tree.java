import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<Integer> left_order_traversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            result.add(Integer.MIN_VALUE); // Null
            return result;
        }
        result.add(root.val);
        if (root.left == null && root.right == null) {
            return result;
        }
        result.addAll(left_order_traversal(root.left));
        result.addAll(left_order_traversal(root.right));
        return result;
    }

    public List<Integer> right_order_traversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            result.add(Integer.MIN_VALUE); // Null
            return result;
        }
        result.add(root.val);
        if (root.left == null && root.right == null) {
            return result;
        }
        result.addAll(right_order_traversal(root.right));
        result.addAll(right_order_traversal(root.left));
        return result;
    }

    public boolean isSymmetric(TreeNode root) {
        List<Integer> left_result = left_order_traversal(root);
        List<Integer> right_result = right_order_traversal(root);
        for (int i = 0; i < left_result.size(); i++) {
            if (!left_result.get(i).equals(right_result.get(i))) {
                return false;
            }
        }
        return true;
    }
}