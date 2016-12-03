import java.util.LinkedList;
import java.util.List;

public class Solution {
    class SegTree {
        int val = 0;
        SegTree left;
        SegTree right;
    }

    private SegTree root;
    private int L;
    private int R;

    private int merge(int a, int b) {
        return a + b;
    }

    private SegTree init(SegTree root, int l, int r) {
        if (l >= r) {
            return root;
        }
        int mid = (l + r) / 2;
        root.left = init(new SegTree(), l, mid);
        root.right = init(new SegTree(), mid + 1, r);
        return root;
    }

    private void update(SegTree root, int l, int r, int i) {
        if (l == r) {
            root.val++;
        } else {
            int mid = (l + r) / 2;
            if (i <= mid) {
                update(root.left, l, mid, i);
            } else {
                update(root.right, mid + 1, r, i);
            }
            root.val = merge(root.left.val, root.right.val);
        }
    }

    public void update(int i) {
        update(root, L, R, i);
    }

    private int countRange(SegTree root, int l, int r, int i, int j) {
        if (l == i && r == j) {
            return root.val;
        }
        int mid = (l + r) / 2;
        if (j <= mid) {
            return countRange(root.left, l, mid, i, j);
        } else if (i > mid) {
            return countRange(root.right, mid + 1, r, i, j);
        } else {
            return merge(
                    countRange(root.left, l, mid, i, mid),
                    countRange(root.right, mid + 1, r, mid + 1, j));
        }
    }

    public int countRange(int i, int j) {
        if (j < i || i > j) {
            return 0;
        } else {
            return countRange(root, L, R, i, j);
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> result = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int invert;
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        if (min < 0) {
            invert = -min;
        } else {
            invert = 0;
        }
        L = min + invert;
        R = max + invert;
        root = init(new SegTree(), L, R);
        for (int i = nums.length - 1; i >= 0; i--) {
            update(nums[i] + invert);
            result.addFirst(countRange(L, invert + nums[i] - 1));
        }
        return result;
    }
}