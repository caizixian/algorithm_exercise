import java.util.HashSet;

public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            // 31~i (inclusive) are 1s and the remaining are 0s
            // extract "more" significant bits
            mask = mask | (1 << i);
            HashSet<Integer> prefixes = new HashSet<>();// Unique prefix
            for (int num : nums) {
                prefixes.add(num & mask);
            }
            int optimalCurrent = max | (1 << i); // Maybe we can set (31-i)th bit to 1
            for (int prefix : prefixes) {
                if (prefixes.contains(optimalCurrent ^ prefix)) {
                    // We can choose a pair of numbers to achieve optimal bits
                    // prefix1 = optimalCurrent ^ prefix2
                    // -> prefix1 ^ prefix2 = optimalCurrent && prefix1 != prefix2
                    max = optimalCurrent;
                    break;
                }
            }
        }
        return max;
    }
}