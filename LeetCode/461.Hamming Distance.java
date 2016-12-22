public class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 31; i++) {
            int extract = 1 << i;
            if ((x & extract) != (y & extract)) {
                count++;
            }
        }
        return count;
    }
}