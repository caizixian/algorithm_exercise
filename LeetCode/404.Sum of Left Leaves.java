import java.util.ArrayDeque;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        ArrayDeque<TreeNode> to_visit = new ArrayDeque<>();
        to_visit.add(root);
        while (!to_visit.isEmpty()) {
            TreeNode tn = to_visit.poll();
            if (tn.left != null) {
                if (tn.left.right == null && tn.left.left == null) {
                    // Is a leaf
                    sum += tn.left.val;
                }
                to_visit.add(tn.left);
            }
            if (tn.right != null) {
                to_visit.add(tn.right);
            }
        }
        return sum;
    }
}