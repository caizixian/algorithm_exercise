import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        for (int index1 = 0; index1 < length - 1; index1++) {
            int index2 = Arrays.binarySearch(numbers,
                    index1 + 1,
                    length,
                    target - numbers[index1]);
            if (index2 < length && index2 > index1) {
                return new int[]{index1 + 1, index2 + 1};// answers are not zero based
            }
        }
        return new int[]{-1, -1};
    }
}