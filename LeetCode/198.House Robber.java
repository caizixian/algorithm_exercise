public class Solution {

    int[][] mem;

    public int calc(int[] nums, int i, int j) {

        if (i > j) {
            return 0;
        }
        if (i == j) {
            return nums[i];
        }
        if (this.mem[i][j] != Integer.MIN_VALUE) {
            return this.mem[i][j];
        }
        int temp = Math.max(nums[i] + calc(nums, i + 2, j), calc(nums, i + 1, j));
        mem[i][j] = temp;
        return temp;
    }

    public int rob(int[] nums) {
        int size = nums.length;
        this.mem = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.mem[i][j] = Integer.MIN_VALUE;
            }
        }
        return calc(nums, 0, nums.length - 1);
    }
}