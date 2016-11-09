import java.util.List;
import java.util.ArrayList;

public class Solution {
    Integer count = 0;
    Integer sum;

    public void binaryTreePaths(TreeNode root, List<Integer> possible_sum) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> now_possible = new ArrayList<>();
        for (Integer i : possible_sum) {
            int temp = i + root.val;
            if (temp == this.sum) {
                this.count++;
            }
            now_possible.add(temp);
        }
        if (root.val == this.sum) {
            this.count++;
        }
        now_possible.add(root.val);
        binaryTreePaths(root.left, now_possible);
        binaryTreePaths(root.right, now_possible);
    }

    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        binaryTreePaths(root, new ArrayList<>());
        return this.count;
    }
}