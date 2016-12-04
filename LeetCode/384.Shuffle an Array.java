import java.util.Random;

public class Solution {

    final private int[] original;
    final private int[] shuf;

    public Solution(int[] nums) {
        original = new int[nums.length];
        shuf = new int[nums.length];
        // Backup original array
        System.arraycopy(nums, 0, original, 0, nums.length);
        System.arraycopy(nums, 0, shuf, 0, nums.length);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        Random r = new Random();
        // Fisher–Yates shuffle
        for (int i = shuf.length - 1; i >= 1; i--) {
            int j = r.nextInt(i + 1); // The bound is exclusive
            int temp = shuf[i];
            shuf[i] = shuf[j];
            shuf[j] = temp;
        }
        return shuf;
    }
}