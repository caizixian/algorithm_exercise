public class Solution {
    private int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    public int kthSmallest(TreeNode root, int k) {
        int leftsize = size(root.left);
        if (k <= leftsize) {
            return kthSmallest(root.left, k);
        } else {
            if (k == leftsize + 1) {
                return root.val;
            } else {
                return kthSmallest(root.right, k - leftsize - 1);
            }
        }
    }
}