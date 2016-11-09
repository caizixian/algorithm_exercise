import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<Integer> prepend_path(Integer prefix, List<Integer> left, List<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        if (left.isEmpty() && right.isEmpty()) {
            result.add(prefix);
        }
        for (Integer i : left) {
            result.add(prefix + i);
        }
        for (Integer i : right) {
            result.add(prefix + i);
        }
        return result;
    }

    public List<Integer> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        return prepend_path(root.val, binaryTreePaths(root.left), binaryTreePaths(root.right));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        for (Integer i : binaryTreePaths(root)) {
            if (i == sum) {
                return true;
            }
        }
        return false;
    }
}