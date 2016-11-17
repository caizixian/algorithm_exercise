public class Solution {
    public int thirdMax(int[] nums) {
        Long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int i : nums) {
            if (i > first) {
                third = second;
                second = first;
                first = (long) i;
            } else if (i > second) {
                if (i != first) {
                    third = second;
                    second = (long) i;
                }

            } else if (i > third) {
                if (i != second) {
                    third = (long) i;
                }
            }
        }
        if (third == Long.MIN_VALUE) {
            return Math.toIntExact(first); //  If it does not exist, return the maximum number.
        } else {
            return Math.toIntExact(third);
        }
    }
}