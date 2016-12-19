import java.util.LinkedList;
import java.util.Deque;

public class BSTIterator {
    private Deque<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        if (root != null) {
            stack.addFirst(root);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void nextLevel() {
        TreeNode root = stack.pollFirst();
        stack.addFirst(root.right);
        stack.addFirst(new TreeNode(root.val));
        stack.addFirst(root.left);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        if (stack.size() == 0) {
            return false;
        }
        TreeNode top = stack.peekFirst();
        if (top == null) {
            stack.removeFirst();
            return hasNext();
        } else {
            if (isLeaf(top)) {
                return true;
            } else {
                nextLevel();
                return hasNext();
            }
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode top = stack.peekFirst();
        if (top == null) {
            stack.removeFirst();
            return next();
        } else {
            if (isLeaf(top)) {
                stack.removeFirst();
                return top.val;
            } else {
                nextLevel();
                return next();
            }
        }
    }
}