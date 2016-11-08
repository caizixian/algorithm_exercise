import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> prepend_path(Integer prefix, List<String> left, List<String> right) {
        ArrayList<String> result = new ArrayList<>();
        if (left.isEmpty()&&right.isEmpty()){
            result.add(prefix.toString());
        }
        for (String s : left) {
            result.add(prefix.toString() + "->" + s);
        }
        for (String s : right) {
            result.add(prefix.toString() + "->" + s);
        }
        return result;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<String>();
        }
        return prepend_path(root.val, binaryTreePaths(root.left), binaryTreePaths(root.right));
    }
}