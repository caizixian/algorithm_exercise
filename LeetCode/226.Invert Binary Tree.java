public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        } else {
            TreeNode tn = new Solution().new TreeNode(root.val);
            tn.right = invertTree(root.right);
            tn.left = invertTree(root.right);
            return tn;
        }
    }
}