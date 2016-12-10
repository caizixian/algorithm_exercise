public class Solution {
    private TreeNode traverse(int[] nums, int i, int j) {
        if (i == j) {
            return null;
        } else {
            int mid = i + (j - i) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = traverse(nums, i, mid);
            root.right = traverse(nums, mid + 1, j);
            return root;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return traverse(nums, 0, nums.length);
    }
}