public class NumArray {
    class SegTree {
        int val;
        SegTree left;
        SegTree right;
    }

    private SegTree root;
    private int R;

    public NumArray(int[] nums) {
        R = nums.length - 1;
        root = init(new SegTree(), 0, R);
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

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

    private void update(SegTree root, int l, int r, int i, int val) {
        if (l == r) {
            root.val = val;
        } else {
            int mid = (l + r) / 2;
            if (i <= mid) {
                update(root.left, l, mid, i, val);
            } else {
                update(root.right, mid + 1, r, i, val);
            }
            root.val = merge(root.left.val, root.right.val);
        }
    }

    public void update(int i, int val) {
        update(root, 0, R, i, val);
    }

    private int sumRange(SegTree root, int l, int r, int i, int j) {
        if (l == i && r == j) {
            return root.val;
        }
        int mid = (l + r) / 2;
        if (j <= mid) {
            return sumRange(root.left, l, mid, i, j);
        } else if (i > mid) {
            return sumRange(root.right, mid + 1, r, i, j);
        } else {
            return merge(
                    sumRange(root.left, l, mid, i, mid),
                    sumRange(root.right, mid + 1, r, mid + 1, j));
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, 0, R, i, j);
    }
}