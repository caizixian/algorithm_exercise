class Result {
    int rob;
    int skip;

    Result(int rob, int skip) {
        this.rob = rob;
        this.skip = skip;
    }
}

public class Solution {
    private Result traverse(TreeNode root) {
        if (root == null) {
            return new Result(0, 0);
        }
        Result l = traverse(root.left);
        Result r = traverse(root.right);

        return new Result(root.val + l.skip + r.skip,
                Math.max(l.rob, l.skip) + Math.max(r.rob, r.skip));
    }

    public int rob(TreeNode root) {
        Result result = traverse(root);
        return Math.max(result.rob, result.skip);
    }
}