public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int ptr1 = 0;
        int ptr2 = length - 1;
        while (ptr1 != ptr2) {
            if (numbers[ptr1] + numbers[ptr2] == target) {
                return new int[]{ptr1 + 1, ptr2 + 1};
            } else {
                if (target - numbers[ptr1] < numbers[ptr2]) {
                    ptr2--;
                } else {
                    ptr1++;
                }
            }
        }
        return new int[]{-1, -1};
    }
}