public class Solution {
    public int numTrees(int n) {
        int[] count = new int[n + 1]; // count[i] = number of trees with i nodes
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // root.val = j
                // all numbers in root.left < j
                // (1~j exclusive) (count j-1)
                // all numbers in root.right > j
                // (j+1 ~ i+1 exclusive) (count i-j)
                count[i] = count[i] + count[j - 1] * count[i - j];
            }
        }
        return count[n];
    }
}