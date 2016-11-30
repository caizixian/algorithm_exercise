public class Solution {
    public int bits(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i & 1;
            i = i >> 1;
        }
        return sum;
    }

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = bits(i);
        }
        return result;
    }
}