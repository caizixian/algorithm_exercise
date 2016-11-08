public class Solution {
    public int depth_and_balanced(TreeNode root) {
        if (root == null) {
            return 0; // Empty node is balanced
        }
        int left_depth = depth_and_balanced(root.left);
        if (left_depth == -1) {
            return -1; // Subtree not balanced, therefore not balanced
        }
        int right_depth = depth_and_balanced(root.right);
        if (right_depth == -1) {
            return -1; // Subtree not balanced, therefore not balanced
        }
        if (Math.abs(left_depth - right_depth) > 1) {
            return -1; // Not balanced
        }
        return 1 + Math.max(left_depth, right_depth);
    }

    public boolean isBalanced(TreeNode root) {
        if (depth_and_balanced(root) == -1) {
            return false;
        }
        return true;
    }
}