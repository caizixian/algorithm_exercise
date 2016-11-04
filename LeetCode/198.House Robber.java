public class Solution {

    int[][] m;

    public int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int size = nums.length;
        this.m = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    this.m[i][j] = nums[i];
                } else {
                    this.m[i][j] = Integer.MIN_VALUE;
                }
            }
        }
        for (int i = 0; i < size-1; i++) {
            m[i][i + 1] = Math.max(nums[i],nums[i+1]);
        }
        for (int interval = 2; interval < size; interval++) {
            for (int i = 0; i < size-interval; i++) {
                m[i][i + interval] = Math.max(nums[i + interval] + m[i][i + interval - 2], m[i][i + interval - 1]);
            }
        }
        return m[0][size-1];
    }
}