public class Solution {
    private int summary(String a) {
        int result = 0;
        for (char c : a.toCharArray()) {
            result = result | 1 << (c - 'a');
        }
        return result;
    }

    private boolean haveCommonChar(int sum_a, int sum_b) {
        return (sum_a & sum_b) > 0;
    }

    public int maxProduct(String[] words) {
        int[] summaries = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            summaries[i] = summary(words[i]);
        }
        int result = 0;
        for (int i = 0; i < summaries.length; i++) {
            for (int j = 1; j < summaries.length; j++) {
                if (!haveCommonChar(summaries[i], summaries[j])) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
}