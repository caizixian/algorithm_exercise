import java.util.ArrayDeque;
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

    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> levelOrderTraverse = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<Level> to_visit = new ArrayDeque<>();

        to_visit.add(new Solution().new Level(root, 0));
        while (!to_visit.isEmpty()) {
            Level lv = to_visit.poll();
            if (levelOrderTraverse.size() < lv.level + 1) {
                levelOrderTraverse.add(new ArrayList<>());
            }
            levelOrderTraverse.get(lv.level).add(lv.tn.val);
            if (lv.tn.left != null) {
                to_visit.add(new Solution().new Level(lv.tn.left, lv.level + 1));
            }
            if (lv.tn.right != null) {
                to_visit.add(new Solution().new Level(lv.tn.right, lv.level + 1));
            }
        }

        for (List<Integer> l : levelOrderTraverse) {
            result.add(l.get(l.size() - 1));
        }
        return result;
    }
}