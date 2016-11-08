import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    class Level {
        TreeNode tn;
        Integer level;

        Level(TreeNode tn, Integer level) {
            this.tn = tn;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<Level> to_visit = new ArrayDeque<>();

        to_visit.add(new Solution().new Level(root, 0));
        while (!to_visit.isEmpty()) {
            Level lv = to_visit.poll();
            if (result.size() < lv.level + 1) {
                result.add(new ArrayList<>());
            }
            result.get(lv.level).add(lv.tn.val);
            if (lv.tn.left != null) {
                to_visit.add(new Solution().new Level(lv.tn.left, lv.level + 1));
            }
            if (lv.tn.right != null) {
                to_visit.add(new Solution().new Level(lv.tn.right, lv.level + 1));
            }
        }
        Collections.reverse(result);
        return result;
    }
}